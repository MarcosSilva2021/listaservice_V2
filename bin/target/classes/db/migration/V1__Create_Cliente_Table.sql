CREATE TABLE `tb_cliente`(
    `id` bigint(20) NOT NULL,
    `nome` varchar(150) NOT NULL,
    `email` varchar(255) DEFAULT NULL,
    `endereco` varchar(255) NOT NULL,
    `login` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_qht682qvopcx5f41dc2rbs5jf` (`login`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
