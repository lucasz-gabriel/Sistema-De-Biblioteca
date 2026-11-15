# 📚 Sistema de Biblioteca

Sistema de gerenciamento de biblioteca com interface gráfica, desenvolvido em **Java** para a disciplina de **Programação Orientada a Objetos (POO)**.

## 📖 Sobre o projeto

O projeto foi criado para praticar POO e a construção de interfaces gráficas com **Java Swing** (`JFrame`, `JTable`, `JComboBox` e outros componentes). O sistema é dividido em três módulos, cada um com sua própria tela:

- 📖 **Livros** (`Book`)
- 👔 **Funcionários** (`Employee`)
- 🧑 **Leitores** (`Readers`)

## ✨ Funcionalidades

Cada módulo possui as mesmas operações, escolhidas em um menu suspenso e executadas pelo botão **Confirmar**:

| Operação | O que faz |
|----------|-----------|
| **Cadastrar** | Adiciona um novo registro (o campo principal é obrigatório) |
| **Pesquisar** | Busca pelo nome/título, sem diferenciar maiúsculas de minúsculas, e destaca o registro na tabela |
| **Modificar** | Substitui os dados do registro selecionado na tabela |
| **Excluir** | Remove o registro selecionado na tabela |
| **Listagem** | Todos os registros ficam visíveis em uma tabela na própria tela |

### 📖 Livros

| Campo | Observação |
|-------|------------|
| Título | Obrigatório, usado na pesquisa |
| Autor | |
| Ano | |
| Editora | |
| Nº de páginas | |
| Último empréstimo | |
| Disponível | Checkbox (marcado por padrão) |

### 👔 Funcionários

| Campo | Observação |
|-------|------------|
| Nome | Obrigatório, usado na pesquisa |
| Código | |
| Tipo sanguíneo | |
| Salário | |
| Endereço | |
| Função | |
| Ativo | Checkbox (marcado por padrão) |

### 🧑 Leitores

| Campo | Observação |
|-------|------------|
| Nome | Obrigatório, usado na pesquisa |
| ID | |
| Data de empréstimo | |
| Relação | |
| Livro alugado | |
| Prazo | |
| Devolvido | Checkbox (desmarcado por padrão) |

## ⚠️ Limitações

- Os dados ficam armazenados **apenas em memória**: ao fechar o programa, tudo é perdido.
- Os módulos são independentes: o campo "Livro Alugado" do leitor é apenas texto e não atualiza a disponibilidade do livro.
- Os campos não têm validação de formato (ano, salário, datas etc. são tratados como texto).

## 🛠️ Tecnologias utilizadas

| Categoria | Tecnologias |
|-----------|-------------|
| Linguagem | Java |
| Bibliotecas | Java Swing, Java AWT |
| Estruturas de dados | `ArrayList`, `DefaultTableModel` |
| Ferramentas | IntelliJ IDEA, Git e GitHub |

## 📦 Instalação

Pré-requisito: **JDK** instalado.

```bash
git clone https://github.com/SEU-USUARIO/Biblioteca-de-Alexandria-do-Manfrine.git
cd Biblioteca-de-Alexandria-do-Manfrine
```

## ▶️ Como executar

1. Abra a pasta do projeto no IntelliJ ou VSCode (`File > Open`)
2. Execute a classe principal (`[NomeDaClasseMain].java`), do pacote `POO`
3. No menu inicial, escolha o módulo que quer acessar

## 🚀 Possíveis melhorias

- Salvar os dados em arquivo ou banco de dados
- Integrar os módulos (emprestar um livro marca ele como indisponível)
- Validar os campos numéricos e as datas
- Reaproveitar o código repetido entre as telas com herança

## 👥 Autores

- **Lucas Roque** · [GitHub](https://github.com/lucasz-gabriel)
- **Ítalo Pereira** · [GitHub](https://github.com/Italo-P)

Apresentação: **Paulo Gabriel**
