# Projeto Prático Integrador — Engenharia de Software e Orientação a Objetos

## Descrição Geral
Desenvolva o Núcleo de Domínio (Core Domain) de uma aplicação utilizando as melhores práticas de arquitetura, qualidade e automação, em um grupo de 3 a 5 alunos. O objetivo é resolver um problema real de mercado a partir de um dos 10 temas propostos pelo professor.

**Entrega:** Repositório público no GitHub seguindo o padrão: `Eduarda Alencar, Davi Lucas e Pedro`

## Requisitos Técnicos Obrigatórios

- **Orientação a Objetos Avançada (OO):**
  - Encapsulamento, herança/composição justificadas, polimorfismo e alta coesão.

- **Domain-Driven Design (DDD):**
  - Isolamento de regras de negócio nas camadas:
    - `src/domain/`: Entidades, Value Objects, Aggregates
    - `src/application/`: Casos de uso e serviços
    - `src/infrastructure/`: Persistência, adapters

- **Test-Driven Development (TDD):**
  - Histórico de commits deve evidenciar criação de testes antes do código de produção.
  - Todos os testes na pasta `tests/`.

- **Gerenciamento de Dependências:**
  - Manifeste seu gerenciador na raiz (ex: `pom.xml`, `package.json` etc).

- **CI/CD:**
  - Pipeline GitHub Actions `.github/workflows/ci.yml` para build e execução dos testes a cada Pull Request/Push.


## Estrutura de Pastas Obrigatória

```
.
├── .github/
│   └── workflows/
│       └── ci.yml
├── src/
│   ├── domain/
│   ├── application/
│   ├── infrastructure/
│   └── presentation/   (Opcional — Plus)
├── tests/
├── project-meta.json
└── README.md
```

### Metadados (`project-meta.json`)
Deve conter:
```json
{
  "curso": "Nome do Curso",
  "disciplina": "Orientação a Objetos",
  "tema_escolhido": "NÚMERO_DO_TEMA_AQUI",
  "linguagem": "Java / TypeScript / C# / etc",
  "gerenciador_dependencias": "Maven / NPM / etc",
  "integrantes": [
    {"nome": "Nome Aluno 1", "github_username": "user1"},
    {"nome": "Nome Aluno 2", "github_username": "user2"}
  ]
}
```

## Temas Propostos

Escolha um tema dentre os dez abaixo (detalhes completos no arquivo de requisitos):

1. Sistema de Gestão de uma ONG de Adoção de Pets
2. Plataforma de Financiamento Coletivo para Projetos Sociais
3. Sistema de Logística e Entregas Urbanas
4. Marketplace de Economia Circular
5. Sistema de Agendamento e Telemedicina
6. Plataforma de Gestão de Eventos Acadêmicos
7. Sistema de Coworking e Reserva de Espaços
8. Gerenciador de Oficinas Mecânicas
9. Sistema de Gestão de Hortas Comunitárias
10. Aplicativo de Finanças Coletivas

---

## Rubrica de Avaliação

| Critério                      | Indicador de Sucesso                                       | Pontuação |
|------------------------------|------------------------------------------------------------|-----------|
| Infraestrutura & CI/CD       | Build e testes funcionais no GitHub Actions                | 10        |
| Gerenciamento de Dependências| Manifesto correto e dependências de teste                  | 10        |
| Cobertura de Testes (TDD)    | Testes unitários e cenários de sucesso/falha               | 20        |
| Modelagem OO & DDD           | Encapsulamento, Value Objects e regras no domínio          | 20        |
| Trabalho em Equipe via Git   | Commits e PRs distribuídos entre os membros                | 20        |
| Total Obrigatório            |                                                            | 80        |
| 🚀 Bonus (Plus)              | Persistência real + interface gráficana camada presentation | +10       |

---

## Fluxo Sugerido de Trabalho para 3 Colaboradores

### Divisão Recomendada

#### Colaborador 1 — Arquitetura & Integração
- Inicializar o repositório e configurar o `project-meta.json`.
- Estruturar as pastas e configurar o CI/CD logo no início.
- Responsável por integração do código via PRs, revisão, merges e automação.

#### Colaborador 2 — Core Domain e Testes (TDD)
- Modelagem das **Entidades**, **Value Objects** e **Aggregates** utilizando DDD.
- Desenvolvimento guiado a testes (criar cenários de domínio e garantir cobertura de testes).
- Garantir encapsulamento e aderência à arquitetura proposta.

#### Colaborador 3 — Application & Infrastructure
- Implementar os **Cases de Uso** na camada `application`.
- Desenvolver/adaptar **persistência** e APIs em `infrastructure`.
- (Opcional/Bônus) Interface gráfica e integração na camada `presentation`.

> Revezem as funções conforme o interesse e habilidades para que todos toquem todo o ciclo!

### Fluxo de Trabalho
1. Criação do repositório e arquivo de metadados
2. Configuração de CI/CD
3. Definição das entidades do domínio e Value Objects (Colaborador 2)
4. Casos de uso (Colaborador 3)
5. Testes TDD para domínio (Colaborador 2)
6. Integração final, revisão e merges (Colaborador 1)
7. (Opcional) Interface gráfica + persistência real (Plus)

### Boas Práticas de Equipe
- Use branches nomeadas por funcionalidade/bugfix
- Sempre integre por Pull Request com revisão entre colegas
- Mantenha o histórico de commits balanceado entre todos
- Testem localmente e verifiquem o status do build antes de abrir PR

---

## Observações Finais
- A escolha do tema define os requisitos específicos do domínio.
- O histórico do Git e a automação do CI/CD são parte da avaliação pela banca/IA.
- Siga rigorosamente o padrão de arquivos/pastas e commits para garantir a nota máxima.
