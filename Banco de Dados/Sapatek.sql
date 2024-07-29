create schema sapatek;
use sapatek;

create  table fornecedor (
	id_fornecedor int not null auto_increment,
    nome varchar(45) not null,
    cnpj bigint (14) not null,
    cep int (8) not null,
    rua varchar(45),
    cidade varchar(45),
    bairro varchar(45),
    estado varchar(45),
    telefone int not null,
    email varchar(45) not null,
    website varchar(60),
    numero int,
    primary key (id_fornecedor)
);

create table produto (
	id_produto int not null auto_increment,
    id_fornecedor int not null,
    nome varchar(45) not null,
    categoria varchar(20) not null,
    qnt int not null,
    descricao varchar(100),
    modelo varchar(40) not null,
    marca varchar(45) not null,
    estilo varchar(45),
    tipo varchar(45),
    primary key (id_produto),
    constraint fk_produto_fornecedor foreign key (id_fornecedor)
		references fornecedor (id_fornecedor) on delete cascade on update cascade
);

create index fk_produto_fornecedor_idx on fornecedor (id_fornecedor);


create table funcionario (
	id_funcionario int not null auto_increment,
    cpf bigint(11) not null,
    nome varchar(45) not null,
    telefone bigint not null,
    cep int (8) not null,
    rua varchar(45),
    bairro varchar(45),
    estado varchar(45),
    cidade varchar(45),
    email varchar(45) not null,
    sexo varchar(45) not null,
    numero_residencial int not null,
    primary key (id_funcionario)
);

use sapatek; 
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Sousa Imports",25444757000187,54678000,"Rua Da Saudade","Soledade","Divinopolis","Minas Gerais",987654678,"sousaimports@gmail.com","www.sousaimports.com",17);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Calçados Império",43789523000167,26574000,"Rua Lisboa","Dom Pedro","Curvelo","Minas Gerais",987654321,"calçadosimperio@gmail.com","www.calçadosimperio@gmail.com",54);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Passos Inovadores",15467823000272,23557000,"Rua Salomão","Limoeiro","Santarem","Para",987654322,"passosinovadores@gmail.com","www.passosinovadores.com",87);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Pé na Leveza",45389201000197,28695000,"Rua 54","Felicidade","Jaboticabau","Minas Gerais",987654323,"penaleveza@gmail.com","www.penaleveza.com",73);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Calçados Dona Maria",35467930000287,87458000,"Rua Das Flores","Nova Friburgo","Juazeiro","Bahia",987654324,"calcadosdonamaria@gmail.com","www.calcadosdonamaria.com",94);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Imperial Shoes",234561894000224,32415000,"Rua Solimões","São Tomé","Itu","São Paulo",987654325,"imperialshoes@gmail.com","www.imperialshoes.com",945);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Conforto Total",23468194000235,75434000,"Rua Jacarepagua","Getúlio Vargas","Republica Velha","Goias",987654326,"confortototal@gmail.com","www.confortototal.com",468);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Pé de Poeta",15468293000256,34578000,"Rua Da Jabuticaba","Medelin","Colombia","São Paulo",987654327,"pedepoeta@gmail.com","www.pedepoeta.com",967);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Calçados Clássicos",16482945000184,45362000,"Rua Conceição","Cachoeira","Chapecó","SAnta Catarina",987654346,"calcadoscalssicos@gmail.com","www.calcadoscalssicos.com",34);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Tendencia Pés",25478923000184,34268000,"Rua Igarapé","Santa Ana","Manaus","Amazonas",987654345,"tendenciapes@gmail.com","www.tendenciapes@gmail.com",790);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Sapatenis Alegria",34627891000193,45276000,"Rua Cachoeira","Centro","Florianopolis","Santa Catarina",987654344,"sapatenisalegria@gmail.com","www.sapatenisalegria.com",673);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Adidas Brasil",34256178000234,94532000,"Rua 78","Colorado","Sorocaba","São Paulo",987654343,"adidasbr@gmail.com","www.adidasbr.com",252);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("NIke Br",23476913000134,34256000,"Rua Santa Cruz","Jequitiba","Santarem","Pará",987654342,"nikebr@gmail.com","www.nikebr.com",786);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Olympikus",2467839000127,93421000,"Rua João Pereira","Laranjeira","Cuiaba","Mato Grosso",987654340,"olynpikus@gmail.com","www.olynpikus.com",945);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Fila",24357861000128,34256000,"Rua São João","Tatuapé","Rio Branco","Acre",98765-4338,"filla@gmail.com","www.filla.com",235);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Sapataria Do Seu Zé",23471893000176,45362000,"Rua Itajaí","Jacaranda","Belém","Pará",987654336,"sapatariadoseuze@gmail.com","www.sapatariadoseuze.com",945);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Atelier Da Ana",35493028000148,34209000,"Rua Jatobá","Santa Cecília","Itaúna","Minas Gerais",987654334,"atelierdaana@gmail.com","www.atelierdaana.com",823);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Conforto Total",23465789000183,56479000,"Rua Rio Negro","Amazonas","Carmopolis","Minas Gerais",987654333,"confortototal@gmail.com","www.confortototal.com",824);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Noble Bots",23456822000167,15273000,"Rua São Francisco","Doutor Joaquim","Belo Horizonte","Minas Gerais",987654332,"nobleboots@gmail.com","www.nobleboots.com",674);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Calçados Do Futuro",26384519000190,23145000,"Rua Aparecida","Guaratingueta","São Paulo","São Paulo",974537234,"calcadosdofuturo@gmail.com","www.calcadosdofuturo.com",123);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Salto Chic",546278310000124,83425000,"Rua Salomé","Persa","Funilandia","Minas Gerais",979792323,"saltochic@gmail.com","www.saltochic.com",520);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Calçar Sorrir",8452637000167,45326000,"Rua do Tomate","Sesmarias","Santana De Parnaiba","São Paulo",968681212,"calcarsorrir@gmail.com","www.calcarsorrir.com",568);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Passos Firmes",16472894000245,92314000,"Rua da Lagoa","Barro Preto","Porto Alegre","Rio Grande Do Sul",957570101,"passosfirmes@gmail.com","www.passosfirmes.com",521);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Conforto Em Todo Lugar",23415678000274,12345000,"Rua São Paulo","Areão","Recife","Pernanbuco",946468989,"confortemtodolugar@gmail.com","www.confortemtodolugar.com",894);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Chinelos Charmosos",23748743000203,23145000,"Rua Fernando Pessoa","Leites","Itu","São Paulo",924246767,"chineloscharmosos@gmail.com","www.chineloscharmosos.com",678);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Sapatos Vintage",045362789000176,34256000,"Rua Sabará","Agua Limpa","Aracaju","Serjipe",913135656,"sapatosvintage@gmail.com","www.sapatosvintage.com",937);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Estilo Impecavel",54263789000185,84531000,"Rua Santa Rita","Campestre","Maceio","Alagoas",902024545,"estiloimpecavel@gmail.com","www.estiloimpecavel.com",923);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Sonhos Nos Pés",84536293000232,23145000,"Rua Piracicaba","Machados","Bonfim","Minas Gerais",991913434,"sonhosnospes@gmail.com","www.sonhosnospes.com",894);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Memórias Retro",05536278000184,34517000,"Rua Santa Fé","Retiro","Piracema","Minas Gerais",980802323,"memoriasretro@gmail.com","www.memoriasretro.com",831);
insert into fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero)
values ("Saltos Sonhadores",23415627000123,94532000,"Rua Cruciândia","São Geraldo","Piedade Dos Gerais","Minas Gerais",979791212,"saltossonhadores@gmail.com","www.saltossonhadores.com",673);

insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(1,"Tênis All Star","Casual",34,"Tênis cano baixo de lona com cadarço, ideal para o dia a dia.","All Star Chuck Taylor","Converse","Casual","Tênis");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(2,"Sandália Anabela","Social",65,"Sandália de salto alto com plataforma, ideal para ocasiões especiais.","Anabela Plataforma","Arezzo","Social","Sandália");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(3,"Sapato Oxford","Social",63,"Sapato social masculino de couro com cadarço, ideal para trabalho ou eventos formais.","Oxford Clássico","Ricardo Almeida","Social","Sapato Social");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(4,"Bota Coturno","Casual",73,"Bota de cano alto de couro com cadarço, ideal para o inverno ou para um visual mais despojado.","Coturno Cano Alto","Moleca","Casual","Bota");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(5,"Chinelo Havaianas","Casual",94,"Chinelo de dedo feito de borracha, ideal para praia, piscina ou para relaxar em casa.","Havaianas Slim","Havaianas","Casual","Chinelo");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(6,"Rasteira","Casual",69,"Sapato feminino sem salto, ideal para o dia a dia ou para um look mais confortável.","Rasteirinha Tiras Finas","Renner","Casual","Rasteira");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(7,"Sneaker","Esportivo",83,"Tênis esportivo para corrida ou academia.","Ultraboost 22","Adidas","Esportivo","Tênis");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(8,"Slide","Casual",56,"Sapato masculino sem cadarço, ideal para o dia a dia ou para um look relaxado.","Slide Couro","Rider","Casual","Slide");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(9,"Sapatenis Plataforma","Casual",86,"Tênis feminino com plataforma, ideal para um look mais moderno e descolado.","Plataforma Atari","Dafiti","Casual","Tênis");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(10,"Bota Chelsea","Social",56,"Bota de cano curto sem cadarço, ideal para trabalho ou eventos casuais.","Chelsea Couro","Carrano","Social","Bota");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(11,"Tênis All Star","Casual",84,"Tênis cano baixo branco com logo preto na lateral","Chuck Taylor All Star","Converse","Casual","Esporte");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(12,"Sandália Anabela Rasteira","Casual",67,"Sandália rasteira de couro caramelo com tiras cruzadas","Anabela","Arezzo","Boho","Casual");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(13,"Scarpin Scarpin Verniz","Social",95,"Scarpin preto de verniz com salto agulha","Scarpin Clássico","Capodarte","Elegante","Social");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(14,"Bota Chelsea Cano Curto","Casual",58,"Bota chelsea marrom de camurça com elástico lateral","Chelsea","Moleca","Urbano","Casual");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(15,"Slide Couro Preto","Casual",45,"Slide de couro preto com fivela prata","Slide","Havaianas","Streetwear","Casual");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(16,"Tênis Esportivo Corrida","Esporte",56,"Tênis de corrida azul com detalhes em verde neon","Ultraboost 22","Adidas","Esportivo","Corrida");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(17,"Rasteirinha de Crochê","Praia",56,"Rasteirinha branca de crochê com pompons","Rasteirinha","Renner","Romântico","Praia");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(18,"Sapato Oxford Marrom","Social",34,"Sapato oxford marrom de couro liso com cadarços","Oxford Brogue Mr. Cat","Business","Casual","Social");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(19,"Bota Coturno Preta","Inverno",67,"Bota coturno preta de couro com cadarços e zíper lateral","Coturno Plataforma","Santa Lolla","Rocker","Inverno");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(20,"Sandália Salto Alto Transparente","Festa",89,"Sandália de salto alto transparente com tiras finas e glitter","Sandália Laço","Vizzano","Glamouroso","Festa");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(21,"Tênis All Star","Casual",54,"Tênis cano baixo de lona com cadarço, ideal para o dia a dia.","All Star Classic","Converse","Casual","Esporte");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(22,"Sandália Anabela","Social",89,"Sandália de salto alto e plataforma, perfeita para ocasiões especiais.","Anabela Plataforma","Arezzo","Elegante","Social");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(23,"Scarpin Scarpin","Social",96,"Sapato de salto alto fino e bico fino, ideal para eventos formais.","Scarpin Clássico","Capodarte","Elegante","Social");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(24,"Bota Chelsea","Casual",96,"Bota de cano curto sem cadarço, fácil de calçar e combinar com diversos looks.","Chelsea Boot","Bottero","Casual","Botas");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(25,"Rasteirinha Havaiana","Praia",78,"Sandália rasteira de dedo com tira única, ideal para dias quentes e descontraídos.","Havaiana Slim","Havaianas","Casual","Sandálias");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(26,"Sapato Oxford","Social",67,"Sapato de couro com cadarço e sola baixa, ideal para um visual social clássico.","Oxford Brogue","Ricardo Almeida","Formal","Social");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(27,"Tênis Esportivo","Esporte",56,"Tênis leve e respirável, perfeito para prática de esportes ou academia.","Ultraboost 22","Adidas","Esportivo","Tênis Running");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(28,"Bota Coturno","Casual",89,"Bota de cano alto com cadarço e sola robusta, ideal para um visual despojado.","Coturno Kanister","Timberland","Casual","Botas");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(29,"Sandália Gladiator","Social",56,"Sandália com tiras largas entrelaçadas, ideal para um look sensual e feminino.","Gladiator Sand","Schutz","Elegante","Sandálias");
insert into produto (id_fornecedor,nome,categoria,qnt,descricao,modelo,marca,estilo,tipo)
values(30,"Sapato Mocassim","Casual",98,"Sapato sem cadarço com costuras aparentes, ideal para um visual casual e confortável.","Mocassim","Loafer","Casual","Sapatos Slip-On");

insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(56475789980,"Ana Silva Souza",1199999999,12345678,"Rua das Flores","Centro","SP","São Paulo","ana.silva@email.com","Feminino",123);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(17684664411,"João Pereira Oliveira",2188888888,45678901,"Rua do Sol","Copacabana","Rio De Janeiro","Rio de Janeiro","joao.oliveira@email.com","Masculino",456);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(27463222222,"Maria Gomes Cardoso",3177777777,78901234,"Rua da Lua","Barreiro","Minas Gerais","Belo Horizonte","maria.cardoso@email.com","Feminino",789);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(33333333333,"Pedro Santos Araújo",8166666666,01234567,"Rua das Estrelas","São João","Pernanbuco","Recife","pedro.araujo@email.com","Mascuulino",012);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(44444676844,"Isabela Costa Lima",5155555555,34567890,"Rua da Praia","Bairro Ypé","Rio Grande do Sul","Porto Alegre","isabela.lima@email.com","Feminino",345);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(80076788801,"Carlos Oliveira Gomes",2188888888,23456789,"Rua das Palmeiras","Centro","Rio de Janeiro","Rio de Janeiro","carlosoliveiragomes@email.com","Masculino",456);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(99908777802,"Maria Ferreira Santos",3177777777,34567890,"Rua dos Girassóis","Vila Nova","Minas Gerais","Belo Horizonte","mariaferreirasantos@email.com","Feminino",789);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(78123456789,"Pedro Nunes",2222222222,20000001,"Rua A","Centro","Rio de Jameiro","Rio de Janeiro","pedro.nunes@email.com","Masculino",1);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(80234567890,"Júlia Barbosa",3333333333,30000002,"Rua B","Copacabana","Rio de Janeiro","Rio de Janeiro","julia.barbosa@email.com","Feminino",2);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(40345678901,"Marcos Silva",4444444444,40000003,"Rua C","Ipanema","Rio de Janeiro","Rio de Janeiro","marcos.silva@email.com","Masculino",3);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(80456789012,"Ana Costa",5555555555,50000004,"Rua D","Leblon","Rio de Janeiro","Rio de Janeiro","ana.costa@email.com","Feminino",4);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(80567890123,"Paulo Souza",6666666666,60000005,"Rua E","Barra da Tijuca","Rio de Janeiro","Rio de Janeiro","paulo.souza@email.com","Masculino",5);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(90678901234,"Carolina Oliveira",7777777777,70000-006,"Rua F","Recreio dos Bandeirantes","Rio de Janeiro","Rio de Janeiro","carolina.oliveira@email.com","Feminino",6);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(60789012345,"Daniel Gomes",8888888888,80000-007,"Rua G","Jacarepaguá","Rio de Janeiro","Rio de Janeiro","daniel.gomes@email.com","Masculino",7);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(80890123456,"Isabella Santos",9999999999,90000008,"Rua H","Vila Isabel","Rio de Janeiro","Rio de Janeiro","isabella.santos@email.com","Feminino",8);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(80901234567,"Rafael Reis",2121212121,11000-009,"Rua I","Méier","Rio de Janeiro","Rio de Janeiro","rafael.reis@email.com","Masculino",9);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(41012345678,"Luana Pereira",3232323232,12000-010,"Rua J","Engenho de Dentro","Rio de Janeiro","Rio de Janeiro","luana.pereira@email.com","Feminino",10);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(21134567891,"Brenda Albuquerque",7878787878,13000011,"Rua K","Méier","Rio de Janeiro","Rio de Janeiro","brenda.albuquerque@email.com","Feminino",11);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(91245678902,"Carlos Almeida",8989898989,14000012,"Rua L","Méier","Rio de Janeiro","Rio de Janeiro","carlos.almeida@email.com","Masculino",12);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(71356789013,"Daniela Costa",9090909090,15000013,"Rua M","Engenho de Dentro","Rio de Janeiro","Rio de Janeiro","daniela.costa@email.com","Feminino",13);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(31467890124,"Eduardo Souza",1111111111,16000014,"Rua N","Jacarepaguá","Rio de Janeiro","Rio de Janeiro","eduardo.souza@email.com","Masculino",14);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(11689012346,"Gabriela Gomes",3333333333,18000-016,"Rua P","Barra da Tijuca","Rio de Janeiro","Rio de Janeiro","gabriela.gomes@email.com","Feminino",16);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(31578901235,"Felipe Oliveira",2222222222,17000-015,"Rua O","Recreio dos Bandeirantes","Rio de Janeiro","Rio de Janeiro","felipe.oliveira@email.com","Masculino",15);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(11790123457,"Henrique Santos",4444444444,19000-017,"Rua Q","Leblon","Rio de Janeiro","Rio de Janeiro","henrique.santos@email.com","Masculino",17);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(51801234568,"Isabela Reis",5555555555,20000-018,"Rua R","Ipanema","Rio de Janeiro","Rio de Janeiro","isabela.reis@email.com","Feminino",18);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(61912345679,"João Pereira",6666666666,21000-019,"Rua S","Copacabana","Rio de Janeiro","Rio de Janeiro","joao.pereira@email.com","Masculino",19);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(82023456780,"Laura Silva",7777777777,22000-020,"Rua T","Centro","Rio de Janeiro","Rio de Janeiro","laura.silva@email.com","Feminino",20);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(82134567891,"Marina Albuquerque",8888888888,23000-021,"Rua U","Vila Isabel","Rio de Janeiro","Rio de Janeiro","marina.albuquerque@email.com","Feminino",21);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(82245678902,"Mateus Almeida",9999999999,24000-022,"Rua V","Méier","Rio de Janeiro","Rio de Janeiro","mateus.almeida@email.com","Masculino",22);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(22356789013,"Nicole Costa",2121212121,25000-023,"Rua W","Engenho de Dentro","Rio de Janeiro","Rio de Janeiro","nicole.costa@email.com","Feminino",23);
insert into funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial)
values(82467890124,"Pedro Souza",3232323232,26000-024,"Rua X","Jacarepaguá","Rio de Janeiro","Rio de Janeiro","pedro.souza@email.com","Mascusculino",24);