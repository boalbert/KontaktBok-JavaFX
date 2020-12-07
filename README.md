# Kontaktbok 
## PROJEKTARBETE | Javaverktyg och byggmiljöer | JU20 | ITHS

I denne projektarbete skapade vi en kontaktbok där man kan lista kontakter, söka efter kontakter, uppdatera kontackter och lägga till nya kontakter. Detta kan användaren väljer mellan Lista, Sök, Uppdatera, Lägg till och Ta bort. Detta kan lagras som en lista i applikationen. Kontaktboken lagras på en jason-fil så att alla kontakter finns kvar mellan körningar av programmet. Använderegräsnittet är byggd i JavaFX.

# Specifikation (ULM av projektet)

​		![labb_3](https://tva1.sinaimg.cn/large/0081Kckwgy1glfn96vv7nj30kl0h1abo.jpg)

# Installation
<u>Möjklighet 1:</u> **Klona repository**

Klona repository och köra programmet från terminalen eller i en IDE (till ex. Intellji). OBS: tänk på att lägga till VM Options om du använda Intellji eftersom programmet körs med Java 11 

`$ git clone https://github.com/boalbert/KontaktBok.git`

För att kuna köra programmet måste en köra följande maven kommando först:`mvn clean install`.

Unit-test går att köra via kommando `mvn test`.

<u>Möjlighet 2:</u> **Tanka ner projektet från Docker Hub**

# Licens 

[MIT License](https://opensource.org/licenses/MIT)