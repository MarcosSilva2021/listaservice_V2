CREATE TABLE `tb_servico`(
    `id` bigint(20) NOT NULL,
    `nome` varchar(150) DEFAULT NULL,
    `descricao` varchar(255) DEFAULT NULL,
    `localizacao` varchar(255) NOT NULL,
    `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_servico`
--
ALTER TABLE `tb_servico`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_qht682qvopcx5f41dc2rbs5jf` (`nome`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_servico`
--
ALTER TABLE `tb_servico`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;