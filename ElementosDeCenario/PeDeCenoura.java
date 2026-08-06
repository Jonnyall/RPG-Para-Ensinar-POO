public class PeDeCenoura extends ElementosCenario
	{
	// Essa classe representa os elementos de cenário de PeDeCenoura. São responsáveis pela interação do player, na qual ele pode puxar e ter sorte de conseguir uma cenoura boa ou não (50% de chances).
	
	// Construtor da classe.
	public PeDeCenoura()
		{
		// Chamando o construtor da superclasse ElementosCenario para inicializar o nome e a descrição do elemento de cenário.
		super("Pé de Cenoura", "Um pé de cenoura que pode ser puxado pelo jogador. Ele pode conter uma cenoura boa ou não.");
		}

	// Método sobreescritor da interface Interagivel, que permite ao jogador interagir com o elemento de cenário.
	@Override
	public void interagir(Heroi heroi)
		{
		// Gerando um número aleatório entre 0 e 1 para determinar se o jogador conseguiu uma cenoura boa ou não.
		int chance = (int) (Math.random() * 2);
		
		// Verificando o resultado da interação.
		if (chance == 0)
			{
			// O jogador conseguiu uma cenoura boa.
			System.out.println("Você puxou o pé de cenoura e conseguiu uma cenoura boa!");

			// Logica para adicionar a cenoura boa ao inventário do jogador.
			}
		else
			{
			// O jogador não conseguiu uma cenoura boa.
			System.out.println("Você puxou o pé de cenoura, mas infelizmente não conseguiu uma cenoura boa.");
			}
		}
	}