#include <stdio.h>
#include <stdlib.h>


void* say_hello(void *tid){
	puts("Oi! Eu sou uma thread!");
	pthread_exit(NULL);
} 

int main(){
	pthread_t t1;

	int status = pthread_create(&t1, NULL, say_hello, NULL);
	if (status != 0){
		puts("Problemas ao criar thread.");
		exit(1);
	}


	pthread_join(t1, NULL);

	return 0;
}
