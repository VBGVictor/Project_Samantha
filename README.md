# Project_Samantha

Inicialmente será uma ferramenta de fluxo de caixa dos recebimentos de pacientes para uma clínica de psicólogos. Com o objetivo de ser um site para apresentação do profissional
de seus projetos, abordagens de atendimento, organização de atendimentos e fluxo de caixa. Após um periodo de teste e implementação de novas funções abrirei para clientes 
terem seus perfis disponíveis e assim poder oferecer profissionais dispostos a prestar serviços com valores acessíveis para a população menos favorecida. Segue rotas 
que estão em andamento e póximos passos.

# Rotas

# Procedimentos realizados:

  * Rotas de pacientes:
  
    POST /paciente - Registra um novo paciente
    
    PUT /paciente/:id - Edita o cadastro de um paciente
    
    DELETE /paciente/D/:id - Deleta o cadastro de um paciente
    
    DELETE /paciente/DT/:id - Desabilita o cadastro de um paciente
    
    GET /paciente - Lista todos os pacientes
    
    GET /paciente/ativo - Lista todos os pacientes ativos

  
# Procedimentos a serem realizados:

  * Rotas de autenticação:

    /login - Login
    
    /signup - Cadastro
    
    /validade-email - Valida o email para recuperação de senha
    
    /recovery-password - Recuperação de senha
    
    /users - Lista todos os usuários (Necessita estar autenticado)
    
    
  * Rotas de pacientes:
  
    POST /paciente - Registra um novo paciente
    
    PUT /paciente/:id - Edita o cadastro de um paciente
    
    DELETE /paciente/D/:id - Deleta o cadastro de um paciente
    
    DELETE /paciente/DT/:id - Desabilita o cadastro de um paciente
    
    GET /paciente - Lista todos os pacientes
    
    GET /paciente/ativo - Lista todos os pacientes ativos
    

  * Serviços (Necessita estar autenticado):

    POST /atendimento - Registra um novo atendimento
    
    PUT /atendimento/:id - Edita um atendimento
    
    DELETE /atendimento/:id - Deletar um atendimento
    
    GET /atendimento - Lista todos os atendimento
    

  * Agenda (Necessita estar autenticado):

    POST /sessão - Registra um novo sessão
    
    PUT /sessão/:id - Edita um sessão
    
    DELETE /sessão/:id - Deleta um sessão
    
    GET /sessão - Lista todos os sessão
    
    GET /sessão/:id - Lista um único sessão
    

# 💻 Tecnologias

  * Esse projeto esta sendo desenvolvido com as seguintes técnologias:

      Java
      
      Spring
      
      Json Web Token
      
      MongoDB
      
      Fluter
      
  *OBS: O FrontEnd será desenvolvido em Fluter, mas ficará em outro repositório git.
