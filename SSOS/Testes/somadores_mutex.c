#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>


double slowdown() {
        double x = 0.001;
        for (int j=1; j < 1000000; j++) {
                x = x + (j * x);
        }
        return x;
}

int somar(int start, int limit) {
        int total = 0;
	for (int i=start; i <= limit; i++) {
                total += i;
                slowdown();
	}
        return total;
}

typedef struct {
        int start;
        int limit;
        int *total;
        pthread_mutex_t *mutex;
} params_t;




void *run(void *params) {
        params_t *ptr = (params_t *)params;
        int total_parcial = somar(ptr->start, ptr->limit);

        // protegendo a região crítica
        pthread_mutex_lock(&(*ptr->mutex));
        int total = *ptr->total;
        sleep(1);
        total = total + total_parcial;
        *ptr->total = total;
        pthread_mutex_unlock(&(*ptr->mutex));
        // fim da região crítica

        pthread_exit(NULL);
}


int main() {
	const int n = 10000;
	const int m = 4;
	const int tam_lote = n / m;
        int total = 0;

        printf("# workers: %d\n", m);

        pthread_t threads[m];
        params_t params[m];

        params->mutex = (pthread_mutex_t *)malloc(sizeof(pthread_mutex_t));

        // iniciando mutex
        pthread_mutex_init((params->mutex), NULL);

        // soltando processos filhos
	int start = 1;
	int limite = tam_lote;
	for (int i=0; i < m; i++) {
		// printf("Filho %d: [%d, %d]\n", i, start, limite);
                params[i].start = start;
                params[i].limit = limite;
                params[i].total = &total;
                pthread_create(&threads[i], NULL, run, (void *)&params[i]);

		start = limite + 1;
		limite = limite + tam_lote;

                // É o último passo?
                if (n - limite < tam_lote) {
                        limite = n;
                }
	}

        // aguardando finalização dos filhos
	for (int i=0; i < m; i++) {
                pthread_join(threads[i], NULL);
                // printf("[Filho %d] parcial = %d\n", i, res);
        }

        printf("Total: %d\n", total);

	return 0;
}
