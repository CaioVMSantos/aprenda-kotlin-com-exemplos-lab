enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    // Método para matricular os usuários
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }

    // Exibir os inscritos
    fun exibirInscritos() {
        println("Inscritos na formação $nome: ")
        inscritos.forEach { println(it.nome) }
    }

    // Exibir conteúdos
    fun exibirConteudos() {
        println("Conteúdos da formação $nome: ")
        conteudos.forEach { println("${it.nome} - ${it.duracao} min - Nível: ${it.nivel}") }
    }
}

fun main() {
    
    // Criando usuários
    val usuario1 = Usuario("Caio Victor")
    val usuario2 = Usuario("Maria Jullya")

    // Criando conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 120, Nivel.BASICO)
    val poo = ConteudoEducacional("Programação Orientada a Objetos", 180, Nivel.INTERMEDIARIO)
    val estruturasDados = ConteudoEducacional("Estruturas de Dados", 200, Nivel.DIFICIL)

    // Criando uma formação
    val formacaoDesenvolvimento = Formacao("Formação Desenvolvimento Kotlin", listOf(kotlinBasico, poo, estruturasDados))

    // Matriculando usuários
    formacaoDesenvolvimento.matricular(usuario1)
    formacaoDesenvolvimento.matricular(usuario2)

    // Exibindo conteúdos e inscritos
    formacaoDesenvolvimento.exibirConteudos()
    formacaoDesenvolvimento.exibirInscritos()
}
