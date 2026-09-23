package src.ElementosDeCenario;

import src.Heroi;
import src.Localidade;
import src.Item;
import src.Missao;

public class Porta extends ElementosCenario
    {
    // Esta classe serve para representar as portas. Elementos do cenário que vão permitir a passagem do herói apenas se ele possuir uma chave correta em seu inventário.
    // Ou tiver cumprido as missões necessarias para abrir a porta.
    // (Nunca uma porta vai ter missões e chaves ao mesmo tempo. Ou uma coisa ou outra.)
	
    // Algumas constantes.
    public static final int PORTA_POR_CHAVE = 1; // Constante para indicar que a porta precisa de uma chave para ser aberta.
    public static final int PORTA_POR_MISSOES = 2; // Constante para indicar que a porta precisa de missões para ser aberta.

	// A chave. Um item para ser usado para abrir a porta.
	Item chave;

    // As missões que podem estar ligadas a necessidade de abrir a porta.
	Missao[] missoesNecessarias;

    // A localidade que a porta leva. (A porta é uma passagem para outra localidade.)
    Localidade localidadeDestino;

    // O tipo da porta. Se ela precisa de uma chave ou de missões para ser aberta.
    int tipoPorta;
	
    // Construtor da classe. (Caso a porta necessite ser aberta com uma chave.)
    public Porta(String nome, String descricao, Item chave, Localidade localidadeDestino)
		{
        // Trabalhando na descrição da porta. Adicionando a informação de que ela precisa de uma chave para ser aberta e para onde leva.
        descricao += " Esta porta precisa de uma chave " + chave.obterNome() + " para ser aberta. Ela leva para a localidade: " + localidadeDestino.obterNome() + ".";
        
        // Atribuindo as características da classe pai.
		super(nome, descricao);
		
		// Linkando a chave que será usada para abrir a porta.
		this.chave = chave;

        // Linkando a localidade de destino.
        this.localidadeDestino = localidadeDestino;

        // Definindo o tipo da porta como sendo uma porta que precisa de uma chave para ser aberta.
        this.tipoPorta = PORTA_POR_CHAVE;
		}

    // Construtor da classe. (Caso a porta necessite ser aberta com missões.)
    public Porta(String nome, String descricao, Missao[] missoesNecessarias, Localidade localidadeDestino)
        {
        // Trabalhando na descrição da porta. Adicionando a informação de que ela precisa de missões para ser aberta e para onde leva.
        descricao += " Esta porta precisa das seguintes missões para ser aberta: ";
        for (int i = 0; i < missoesNecessarias.length - 1; i++)
            {
            descricao +=  missoesNecessarias[i].obterNome() + ", ";
            }
        descricao += missoesNecessarias[missoesNecessarias.length - 1].obterNome() + ". ";
        descricao += " Ela leva para a localidade: " + localidadeDestino.obterNome() + ".";

        // Atribuindo as características da classe pai.
		super(nome, descricao);

        // Linkando as missões que serão usadas para abrir a porta.
        this.missoesNecessarias = missoesNecessarias;

        // Linkando a localidade de destino.
        this.localidadeDestino = localidadeDestino;

        // Definindo o tipo da porta como sendo uma porta que precisa de missões para ser aberta.
        this.tipoPorta = PORTA_POR_MISSOES;
        }
    
		
	// Método sobreescritor da interface Interagivel.
    // Verifica se o jogador possui a chave correta em seu inventário para abrir a porta.
    @Override
    public void interagir(Heroi heroi)
        {        
        // Primeiro, verificando o tipo da porta. Se ela precisa de uma chave ou de missões para ser aberta.
        if (this.tipoPorta == PORTA_POR_MISSOES)
            {
            // A porta precisa de missões para ser aberta.
            // Verificando se o herói possui todas as missões necessárias para abrir a porta.
            boolean possuiTodasMissoes = heroi.verificarMissoesCompletadas(missoesNecessarias);

            if (possuiTodasMissoes)
                {
                // O herói possui todas as missões necessárias. A porta pode ser aberta.
                System.out.println("Você completou todas as missões necessárias para abrir a porta!");
                
                // Levando o herói para a localidade de destino.
                heroi.mudarLocalidade(localidadeDestino);
                }
            else
                {
                // O herói não possui todas as missões necessárias. A porta permanece fechada.
                System.out.println("Você não completou todas as missões necessárias para abrir esta porta.");
                }
            }
        else if (this.tipoPorta == PORTA_POR_CHAVE)
            {
            // Verificando se o inventário do herói contém a chave correta para abrir a porta.
            if (heroi.possuiItemNoInventario(chave))
                {
                // O herói possui a chave correta. A porta pode ser aberta.
                System.out.println("Você usou a chave correta para abrir a porta!");
                
                // Levando o herói para a localidade de destino.
                heroi.mudarLocalidade(localidadeDestino);
                }
            else
                {
                // O herói não possui a chave correta. A porta permanece fechada.
                System.out.println("Você não possui a chave correta para abrir esta porta.");
                }
            }
        }
    }