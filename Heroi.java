import java.util.ArrayList;

public class Heroi extends Personagem implements Updateble
    {
    // Esta classe representa o personagem principal do jogo, aquele que o jogador controla.

    // Atributos do personagem (Hero).

	// O inventário que o herói carrega.
	private Inventario inventario_do_heroi;

    // A Missão que o herói está realizando.
    private Missao missao_atual;

    // A lista de missões que o herói já completou.
    private ArrayList<Missao> missoes_completadas = new ArrayList<Missao>(); // Lista é inicializada vazia, pois o herói ainda não completou nenhuma missão.

    // Construtor da classe.
    public Heroi()
        {
        // Ficha do heroi: Nome, Vida, Ataque, Defesa, Sorte.
        /*
            Nome: Herói
            Vida: 100
            Ataque: 20
            Defesa: 10
            Sorte: 5
        */
        super("Heroi", 100, 20, 10, 5);
        
        // Inicializando (ou instanciando) o inventário do Heroi.
        this.inventario_do_heroi = new Inventario();
        }
    
    // Métodos da classe.
    public void darEspadada(Inimigo inimigo)
        {
        // Aqui será implementado a lógica para o heroi dar uma espada.
        }

    public void darFlechada(Inimigo inimigo)
        {
        // Aqui será implementado a lógica para o heroi dar uma flechada.

        // Primeiro vare-se o inventário do herói para verificar se ele possui flechas.
        if (this.inventario_do_heroi.quantidadeItemEspecifico(Item.FLECHA) > 0)
            {
            // Se o herói possui flechas, ele pode dar uma flechada.
            
            // Aqui poderia ser implementada a lógica para causar dano ao inimigo com a flechada.

            // Após dar a flechada, o herói deve perder uma flecha do seu inventário.
            this.inventario_do_heroi.removerItem(Item.FLECHA);
            }
        else
            {
            // Se o herói não possui flechas, ele não pode dar uma flechada.
            System.out.println("O heroi não possui flechas para dar uma flechada.");
            }
        }

    public void lançarBomba(Inimigo [] inimigo)
        {
        // Aqui será implementado a lógica para o heroi lançar uma bomba em vários inimigos.

        // Primeiro vare-se o inventário do herói para verificar se ele possui bombas.
        if (this.inventario_do_heroi.quantidadeItemEspecifico(Item.BOMBA) > 0)
            {
            // Se o herói possui bombas, ele pode lançar uma bomba.
            System.out.println("O heroi lançou uma bomba nos inimigos!");

            // Aqui poderia ser implementada a lógica para causar dano a todos os inimigos com a bomba.

            // Após lançar a bomba, o herói deve perder uma bomba do seu inventário.
            this.inventario_do_heroi.removerItem(Item.BOMBA);
            }
        else
            {
            // Se o herói não possui bombas, ele não pode lançar uma bomba.
            System.out.println("O heroi não possui bombas para lançar.");
            }
        }


    // Método para se obter o inventário do herói.
    public Inventario getInventario()
        {
        return (this.inventario_do_heroi);
        }

    
    // ---- ATENÇÂO OUD DÚVIDA: O controle de missões do herói deveria ficar na classe Heroi? Ou na classe NPC? Ou em uma outra classe que gerencie as missões do jogo? 

    // Método para completar uma missão.
    public void completarMissao(Missao missao)
        {
        // Adicionando a missão à lista de missões completadas.
        this.missoes_completadas.add(missao);
        }

    // Método para verificar se uma dada missão já foi completada.
    public boolean verificarMissaoCompletada(Missao missao)
        {
        // Verificando se a missão está na lista de missões completadas.
        return (this.missoes_completadas.contains(missao));
        }
    }
