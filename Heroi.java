public class Heroi extends Personagem implements Updateble
    {
    // Esta classe representa o personagem principal do jogo, aquele que o jogador controla.

    // Atributos do personagem (Hero).

	// O inventário que o herói carrega.
	Inventario inventario_do_heroi;

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
    void darEspadada()
        {
        // Aqui será implementado a lógica para o heroi dar uma espada.
        }

    void darFlechada()
        {
        // Aqui será implementado a lógica para o heroi dar uma flechada.
        }

    // Método para se obter o inventário do herói.
    public Inventario getInventario()
        {
        return (this.inventario_do_heroi);
        }
    }
