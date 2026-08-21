package src;

import java.util.ArrayList;
import java.util.List;

import src.ElementosDeCenario.ElementosCenario;

public class Localidade extends TodasAsCoisas
    {
    // Esta classe representa uma localidade do jogo, que pode ser uma cidade, uma floresta, uma caverna, etc. Ela possui atributos como nome, descrição e métodos para interagir com o jogador.

    // Atributos da localidade.
    
    // O nome da localidade.
    private String nome;

    // A descrição da localidade.
    private String descricao;

    // Os objetos que o jogador pode interagir.
    private Interagivel[] interagiveis;

    // Os caminhos possiveis para outras localidades a partir desta localidade.
    private Localidade[] caminhos;

    // Construtor da classe.
    public Localidade(String nome, String descricao)
        {
        this.nome = nome;
        this.descricao = descricao;
        }

    // Métodos da classe.

    // Método para adicionar um caminho para outra localidade.
    public void configurarCaminhos(Localidade[] caminhos)
        {
        this.caminhos = caminhos;

        /*
        OBS.: Como esse atributo precisa de objetos (instâncias) de outras localidades, ele não pode ser configurado no construtor da classe, pois as localidades ainda não foram instanciadas. Por isso, ele é configurado em um método separado.
        */
        }

    // Método para obter o caminho para outras localidades.
    public Localidade[] obterCaminhos()
        {
        return(this.caminhos);
        }

    // Método para adicionar os objetos interativos na localidade.
    public void configurarInteragiveis(Interagivel[] interagiveis)
        {
        this.interagiveis = interagiveis;
        }
    
    // Métodos para se obter NPC e Interágiveis.
    public NPC[] obterNPC()
        {
        // Se a lista (o array) não tiver sido instanciada ainda, retornando imediatamente um array vazio.
        if (this.interagiveis == null)
            {
            return(new NPC[0]);
            }
        
        // Lista temporária.
        List <NPC> _lista_temporaria = new ArrayList<>();
        
        for (int i = 0; i < this.interagiveis.length; i++)
            {
            // Se o interagivel for do tipo NPC, então o adiciona na lista.
            if (this.interagiveis[i] != null && this.interagiveis[i] instanceof NPC)
                {
                // Fazendo a conversão.
                _lista_temporaria.add( (NPC) this.interagiveis[i] );
                }
            }

        // retornando só o array tipado.
        return( _lista_temporaria.toArray( new NPC[0]) );
        }

    // Método para se obter ElementosCenario.
    public ElementosCenario[] obterElementosCenario()
        {
        // Se a lista (o array) não tiver sido instanciada ainda, retornando imediatamente um array vazio.
        if (this.interagiveis == null)
            {
            return(new ElementosCenario[0]);
            }
        
        // Lista temporária.
        List<ElementosCenario> _lista_temporaria = new ArrayList<>();
        
        for (int i = 0; i < this.interagiveis.length; i++)
            {
            // Se o interagível for do tipo ElementosCenario, então o adiciona na lista.
            if (this.interagiveis[i] != null && this.interagiveis[i] instanceof ElementosCenario)
                {
                // Fazendo a conversão.
                _lista_temporaria.add((ElementosCenario) this.interagiveis[i]);
                }
            }

        // Retornando só o array tipado.
        return _lista_temporaria.toArray(new ElementosCenario[0]);
        }



    // Método para se obter o nome da Localidade.
    public String obterNome()
        {
        return (this.nome);
        }

    // Método para se obter a descrição da sala.
    public String obterDescricao()
        {
        return (this.descricao);
        }
    }