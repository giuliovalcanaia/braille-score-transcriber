# BrailleScoreTranscriber

[![CI](https://github.com/giuliovalcanaia/braille-xml/actions/workflows/ci.yml/badge.svg)](https://github.com/giuliovalcanaia/braille-xml/actions/workflows/ci.yml)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

> **[PT-BR]** Ferramenta automatizada para transcrição de partituras digitais no formato MusicXML para a Musicografia Braille. Desenvolvido como projeto acadêmico para a FURB (Universidade Regional de Blumenau) e focado em acessibilidade musical.
>
> **[EN]** An automated tool for transcribing digital sheet music from MusicXML format to Braille Music Notation. Developed as an academic project for FURB (Regional University of Blumenau) with a core focus on musical accessibility.

---

# Glossário

## XML
### Extensible Markup Language
É uma linguagem de marcação (assim como o HTML) e serve para armazenar e estruturar dados de forma limpa e organizada.
O principal objetivo do XML é a serialização, ou seja, armazenar, transmitir e reconstruir dados arbitrários. Para que dois sistemas diferentes troquem informações, eles precisam chegar a um acordo sobre um formato de arquivo. XML padroniza esse processo. É, portanto, análogo a uma língua franca para representar informações.
Diferentemente do HTML que possui tags predefinidas, o xml permite que cada sistema crie e atribua suas próprias tags conforme demanda.

## POJO
### Plain Old Java Object
Para uma classe ser considerada um POJO, ela precisa seguir uma regra simples: ela não pode ter nenhuma dependência de frameworks externos.

Exemplo:
```java
public class Usuario {
    private String nome;
    private String email;

    // Construtor
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

## JAXB
### Java Architecture for XML Binding
É uma ferramenta do ecossistema JAVA que serve para facilitar a serialização e desserialização entre objetos e XML.
#### Termos
- Marshal (empacotar): JAVA → XML
- Unmarshal (desempacotar): XML → JAVA

# Elementos mapeados
De momento estes são todos os elementos mapeados do formato musicXML.
```text
<score-partwise>
├── <credit>
│   ├── <credit-type>
│   └── <credit-words>
└── <part>
    └── <measure>
        ├── <attributes>
        │   ├── <clef>
        │   │   ├── <sign>
        │   │   └── <line>
        │   ├── <key>
        │   │   └── <fifths>
        │   └── <time>
        │       ├── <beats>
        │       └── <beat-type>
        ├── <barline>
        │   ├── <ending> (atributos: number, type)
        │   └── <repeat> (atributos: direction, times)
        ├── <harmony>
        │   ├── <root>
        │   │   └── <root-step>
        │   └── <kind>
        └── <note>
            ├── <pitch>
            │   ├── <step>
            │   ├── <octave>
            │   └── <alter>
            ├── <rest>
            ├── <duration>
            ├── <type>
            └── <tie>
```

# Referências:
É possível encontrar toda a documentação do formato musicmxl e seus respectivos elementos aqui: https://www.w3.org/2021/06/musicxml40/musicxml-reference/element-tree/

Para a transcrição braille foi usado o seguinte documento: https://media.rnib.org.uk/documents/New_International_Manual.pdf
