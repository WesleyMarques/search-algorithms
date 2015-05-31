#!/bin/bash
ALGORITMO=$1 # nome do algoritmo que o experimento ira executar
FILE_BUSCADO=$2 # path do arquivo que a busca sera realizada
FILE_BUSCA=$3 # path do arquivo que contem o que se busca

# diretorio com executaveis do experimento
cd bin/
# executando experimento
java br.com.edu.metodologia.main.manager.Manager $ALGORITMO $FILE_BUSCADO $FILE_BUSCA
