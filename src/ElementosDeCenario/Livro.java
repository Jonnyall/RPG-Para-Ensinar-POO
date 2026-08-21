package src.ElementosDeCenario;

import src.Heroi;

public class Livro extends ElementosCenario
    {
    // Essa classe representa os livros. Interativos, os quais o herói pode ler e ver seu conteúdo.
    
    // O titulo do livro.
    private String titulo;

    // O local onde o livro está (exemplo: na mesa, na escrivania, no altar).
    private String local;

    // O Assunto ou tema do livro.
    private String assunto;

    // O texto que o livro contém será exibido assim que o herói o ler.
    private String texto;
    

    // Método construtor.
    public Livro ( String titulo, String local, String assunto, String texto)
        {
        // A chamada ao construtor da classe pai deve ser a primeira instrução.
        super("livro", "Título: " + titulo + " - Sobre: " + assunto + ", localizado " + local + ".");

        // E atributos da própria classe.
        this.titulo = titulo;
        this.local = local;
        this.assunto = assunto;
        this.texto = texto;
        }

    // Método sobreescritor da interface Interagivel, que permite ao jogador interagir com o elemento de cenário.
	@Override
    public void interagir(Heroi heroi)
        {
        //Pulando uma linha
        System.err.println("\n");

        System.err.println("O Heroi abre o livro \"" +this.titulo +"\" " +this.local +":\n");

        System.err.println(this.texto +"\n\n\n");
        }
    }
