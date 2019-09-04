INSERT INTO CLIENTES(NOME, DOCUMENTO, DATA_NASCIMENTO) 
VALUES ('JOÃO LUCAS', '5879965844', GETDATE()),
	   ('MARIA MESSIAS', '58464488899', GETDATE());


INSERT INTO PRODUTOS(NOME, DESCRICAO, PRECO, DATA_VALIDADE) 
VALUES ('Blusa Ardidas - M' , 'Blusa da Ardidas tamanho M com diversas opções de cores', 450.00, GETDATE()),
	   ('Tênis Old Skool Caravans - 40' , 'Tênis da Caravans Old Skool tamanho 42 com diversas opções de cores', 259.99, GETDATE()),
 	   ('Tênis Naique - 42' , 'Tênis da Naique tamanho 42 com diversas opções de cores', 239.99, GETDATE());
 	  