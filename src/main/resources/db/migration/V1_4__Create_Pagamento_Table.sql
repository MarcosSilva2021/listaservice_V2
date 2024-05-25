CREATE TABLE `tb_pagamento`(
    `id` bigint(20) NOT NULL,
    `nome` varchar(255) NOT NULL,
    `numero` varchar(255) DEFAULT NULL,
    `agencia` varchar(255) NOT NULL,
    `codigoseguranca` varchar(255) NOT NULL  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Índices para tabelas despejadas
--


--
-- Índices de tabela `tb_pagamento`
--
ALTER TABLE `tb_pagamento`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_qht682qvopcx5f41dc2rbs5jf` (`numero`);
--
-- AUTO_INCREMENT para tabelas despejadas
--
--
-- AUTO_INCREMENT de tabela `tb_pagamento`
--
ALTER TABLE `tb_pagamento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
