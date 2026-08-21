package src;

public class Dano extends TodasAsCoisas
    {
    // Esta classe representa os objetos de dano, aqueles que podem "diminuir a vida" dos personagens.

    // Atributos do dano.

    // O PersonagemQueBatalha que o criou.
    private PersonagemQueBatalha criador;

    // Quantos % da força do criador o objeto dano vai usar.(default 100%)
    private double porcentagemForca = 1.0;

    // Quantos % da sorte do criador o objeto dano vai usar.(default 100%)
    private double porcentagemSorte = 1.0;

    // Construtor da classe.
    public Dano(PersonagemQueBatalha criador, double porcentagemForca, double porcentagemSorte)
        {
        // Atribuindo o criador do dano.
        this.criador = criador;
		
		// Iniciada as porcentagem que serão usadas do criador nesses objetos danificados instanciados.
        this.porcentagemForca = porcentagemForca;
        this.porcentagemSorte = porcentagemSorte;
        }

    // Métodos da classe.

    // Método para calcular a chance do dano o correr.
    public boolean calcularChanceDeAcerto(int sorteAlvo)
        {
        // A sorte do "objeto dano".
        int _sorteDano = (int) Math.round(this.criador.obterSorte() * this.porcentagemSorte);

        // Razão entre a sorte do dano e a sorte do alvo. Se a razão for maior que 1, o dano acerta. Se for menor que 1, o dano tem uma chance de não acertar.
        double _razao = (double) _sorteDano / ((double) sorteAlvo + 0.0001); //Apenas para evitar divisão por zero, caso a sorte do alvo seja zero.

        // Se a razão for maior que 1, o dano acerta.
        if (_razao >= 1.0)
            {
            return (true);
            }
        // Se a razão for menor que 1, o dano tem uma chance de não acertar.
        else
            {
            // Gerando um número aleatório entre 0 e 1.
            double _random = Math.random();

            // Se o número aleatório for menor que a razão, o dano acerta.
            if (_random < _razao)
                return (true);
            // Se o número aleatório for maior que a razão, o dano não acerta.
            else
                return (false);
            }
        }
    
    
        // Método para calcular o dano que o objeto dano irá causar.
        public int calcularDano(int defesaAlvo)
            {
            // Calculando o dano que o objeto dano vai causar, levando em consideração a defesa do alvo.
            double _dano = this.criador.obterAtaque() * this.porcentagemForca;
            _dano = (_dano*_dano) / (defesaAlvo + _dano +0.0001); //Apenas para evitar divisão por zero, caso a defesa seja zero.

            // Arredondando o dano causado para o inteiro mais próximo.
            int _dint = (int) Math.round(_dano);

            // Retornando o dano causado.
            return (_dint);
            }
    }
