void main() {
    Scanner scanner = new Scanner(System.in);

    List<Pessoa> banco = new ArrayList<>();
    List<Pessoa> cache = new ArrayList<>();


    banco.add(new Pessoa(1, "kauã", 18));
    banco.add(new Pessoa(2, "Mirella", 17));
    banco.add(new Pessoa(3, "Pablo", 17));
    banco.add(new Pessoa(4, "Emerson", 22));
    banco.add(new Pessoa(5, "Matheus", 21));

    String continuar;

    IO.println("========================================");
    IO.println("                 BANCO                  ");
    IO.println("========================================");

    do {
        IO.println("Digite o ID da pessoa: ");
        int id = scanner.nextInt();

        Pessoa pessoaEncontrada = null;

        for (Pessoa p : cache) {
            if (p.getId() == id) {
                pessoaEncontrada = p;
                break;
            }
        }

        if (pessoaEncontrada != null) {
            IO.println("Pessoa encontrada no cache: " + pessoaEncontrada);
        } else {

            for (Pessoa p : banco) {
                if (p.getId() == id) {
                    pessoaEncontrada = p;
                    break;
                }
            }
        }

        if (pessoaEncontrada != null) {

            if (cache.size() >= 10) {
                Pessoa removida = cache.remove(0);
                IO.println("--> Cache cheio! Removendo o mais antigo: " + removida.getNome());
            }

            if (pessoaEncontrada != null) {

                cache.add(pessoaEncontrada);
                IO.println("Pessoa buscada no banco e adicionada ao cache: " + pessoaEncontrada);
            } else {
                IO.println("Pessoa não encontrada no banco e nem no cache.");
            }
        }


        IO.println("\n [Pessoas atualmente no cache]: ");
        if (cache.isEmpty()) {
            IO.println("(Cache vazio)");
        } else {
            for (Pessoa p : cache) {
                IO.println("-> " + p.getNome() + " (Idade: " + p.getIdade() + " anos)");
            }
            }

            IO.println("\nDeseja adicionar/buscar outra pessoa? (s/n): ");
            continuar = scanner.next();

        }
        while (continuar.equalsIgnoreCase("s"));

        IO.println("\nPrograma finalizado.");



}






