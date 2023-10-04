enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    // Método para matricular um usuário na formação
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    // Método para listar os conteúdos de uma formação
    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        for ((index, conteudo) in conteudos.withIndex()) {
            println("${index + 1}. ${conteudo.nome} (Duração: ${conteudo.duracao} minutos)")
        }
    }
}

fun main() {
    // Criação de alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 180)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 240)

    // Criação de uma formação
    val formacao1 = Formacao("Formação em Ciência da Computação", listOf(conteudo1, conteudo2, conteudo3))

    // Criação de usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")

    // Matricular usuários na formação
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)

    // Listar conteúdos da formação
    formacao1.listarConteudos()
}
