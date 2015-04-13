#include <stdlib.h>
#include <stdio.h>

#include <glib.h>

#include "httpclient/httpclient.h"

int
main(int argc, char *argv[])
{
    HttpClientError *err = NULL;

    HttpContext ctx = httpcontext_create("http://localhost:8080", &err);
    if (err) {
        printf("%s\n", err->message);
        httperror_destroy(err);
        return 1;
    }

    httpcontext_debug(ctx, FALSE);
    httpcontext_read_timeout(ctx, 3000);

    HttpRequest request = httprequest_create(ctx, "/gzipped/content", HTTPMETHOD_GET, &err);
    if (err) {
        printf("%s\n", err->message);
        httperror_destroy(err);
        return 1;
    }

    httprequest_addheader(request, HTTPHKEY_USER_AGENT, "HTTPCLIENT/1.0");

    HttpResponse response = httprequest_perform(request, &err);
    if (err) {
        printf("%s\n", err->message);
        httperror_destroy(err);
        return 1;
    }

    int status = httpresponse_status(response);
    char *message = httpresponse_status_message(response);

    printf("Result: %d - %s\n", status, message);

    GHashTable *headers = httpresponse_headers(response);
    GList *keys = g_hash_table_get_keys(headers);
    GList *curr = keys;
    if (curr) {
        printf("Headers:\n");
        while (curr) {
            printf("  %s: %s\n", (char *)curr->data, (char *)g_hash_table_lookup(headers, curr->data));
            curr = g_list_next(curr);
        }
    }

    char *body = httpresponse_body_as_string(response, &err);
    if (err) {
        printf("%s\n", err->message);
        httperror_destroy(err);
        return 1;
    }

    printf("Body:\n");
    printf("%s\n", body);

    httpresponse_destroy(response);
    httprequest_unref(request);
    httpcontext_unref(ctx);

    return 0;
}
