public class Porta extends ElementosCenario
    {
    // Esta classe serve para representar as portas. Elementos do cenário que vão permitir a passagem do herói apenas se ele possuir uma chave correta em seu inventário.
	
	// A chave. Um item corretor para ser usado para abrir a porta.
	Item chave;
	
	// Construtor da classe.
	public Porta(String nome, String descricao, Item chave)
		{
		// Atribuindo as características da classe pai.
		super(nome, descricao);
		
		// Linkando a chave que será usada para abrir a porta.
		this.chave = chave;
		}
		
	// Método sobreescritor da interface Interagivel.
    // Verifica se o jogador possui a chave correta em seu inventário para abrir a porta.
    @Override
    public void interagir(Heroi heroi)
        {        
        // Verificando se o inventário do herói contém a chave correta para abrir a porta.
        if (heroi.possuiItemNoInventario(chave))
            {
            // O herói possui a chave correta. A porta pode ser aberta.
            System.out.println("Você usou a chave correta para abrir a porta!");
            
            // Aqui você pode adicionar lógica adicional, como permitir que o herói passe para a próxima localidade.
            }
        else
            {
            // O herói não possui a chave correta. A porta permanece fechada.
            System.out.println("Você não possui a chave correta para abrir esta porta.");
            }
        }
    }