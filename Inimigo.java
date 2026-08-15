public abstract class Inimigo extends PersonagemQueBatalha
    {
    // Esta classe representa os inimigos do jogo, aqueles que o personagem (Hero) principal deve enfrentar.

    // Atributos do inimigo.

    // Os itens que o inimigo pode dropar ao ser derrotado.
    private Saque[] saques;

    // Construtor da classe.
    public Inimigo(String nome, int vida, int ataque, int defesa, int sorte, Saque[] saques)
        {
        // Atribuindo de classe da classe superior.
        super(nome, vida, ataque, defesa, sorte);
        
        // Configurando os drops do inimigo.
        this.saques = saques;
        }

    // Declaração do método de atacar o personagem (Heroi), que deve ser implementado por todas as classes filhas de Inimigo.
    public abstract void atacarHeroi(Heroi heroi);
    
    // Método para "dropar" os itens do inimigo ao serem derrotados.
    public void droparItens( Heroi heroi)
        {  
        for (int i = 0; i < saques.length; i++)
            {
            // Aqui poderia ser implementada uma lógica para determinar se o item será dropado ou não, com base na sorte do inimigo e do herói.
            
            // Chamando o método sortearSaque() da classe Saque para determinar se o item será dropado ou não.
            Item item = saques[i].sortearSaque();
            
            // Se o item não for nulo, significa que ele será dropado, então adicionamos ao inventário do herói.
            if (item != null)
                {
                heroi.adicionarItemAoInventario(item);
                }
            }
        }
    }
