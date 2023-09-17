package com.example.karandle

// author: Karan & calren
object FourLetterWordList {
    // List of most common 4 letter words from: https://7esl.com/4-letter-words/
    val fourLetterWords =
        "Area,Army,Baby,Back,Ball,Band,Bank,Base,Bill,Body,Book,Call,Card,Care,Case,Cash,City,Club,Cost,Date,Deal,Door,Duty,East,Edge,Face,Fact,Farm,Fear,File,Film,Fire,Firm,Fish,Food,Foot,Form,Fund,Game,Girl,Goal,Gold,Hair,Half,Hall,Hand,Head,Help,Hill,Home,Hope,Hour,Idea,Jack,John,Kind,King,Lack,Lady,Land,Life,Line,List,Look,Lord,Loss,Love,Mark,Mary,Mind,Miss,Move,Name,Need,News,Note,Page,Pain,Pair,Park,Part,Past,Path,Paul,Plan,Play,Post,Race,Rain,Rate,Rest,Rise,Risk,Road,Rock,Role,Room,Rule,Sale,Seat,Shop,Show,Side,Sign,Site,Size,Skin,Sort,Star,Step,Task,Team,Term,Test,Text,Time,Tour,Town,Tree,Turn,Type,Unit,User,View,Wall,Week,West,Wife,Will,Wind,Wine,Wood,Word,Work,Year,Bear,Beat,Blow,Burn,Call,Care,Cast,Come,Cook,Cope,Cost,Dare,Deal,Deny,Draw,Drop,Earn,Face,Fail,Fall,Fear,Feel,Fill,Find,Form,Gain,Give,Grow,Hang,Hate,Have,Head,Hear,Help,Hide,Hold,Hope,Hurt,Join,Jump,Keep,Kill,Know,Land,Last,Lead,Lend,Lift,Like,Link,Live,Look,Lose,Love,Make,Mark,Meet,Mind,Miss,Move,Must,Name,Need,Note,Open,Pass,Pick,Plan,Play,Pray,Pull,Push,Read,Rely,Rest,Ride,Ring,Rise,Risk,Roll,Rule,Save,Seek,Seem,Sell,Send,Shed,Show,Shut,Sign,Sing,Slip,Sort,Stay,Step,Stop,Suit,Take,Talk,Tell,Tend,Test,Turn,Vary,View,Vote,Wait,Wake,Walk,Want,Warn,Wash,Wear,Will,Wish,Work,Able,Back,Bare,Bass,Blue,Bold,Busy,Calm,Cold,Cool,Damp,Dark,Dead,Deaf,Dear,Deep,Dual,Dull,Dumb,Easy,Evil,Fair,Fast,Fine,Firm,Flat,Fond,Foul,Free,Full,Glad,Good,Grey,Grim,Half,Hard,Head,High,Holy,Huge,Just,Keen,Kind,Last,Late,Lazy,Like,Live,Lone,Long,Loud,Main,Male,Mass,Mean,Mere,Mild,Nazi,Near,Neat,Next,Nice,Okay,Only,Open,Oral,Pale,Past,Pink,Poor,Pure,Rare,Real,Rear,Rich,Rude,Safe,Same,Sick,Slim,Slow,Soft,Sole,Sore,Sure,Tall,Then,Thin,Tidy,Tiny,Tory,Ugly,Vain,Vast,Very,Vice,Warm,Wary,Weak,Wide,Wild,Wise,Zero,Ably,Afar,Anew,Away,Back,Dead,Deep,Down,Duly,Easy,Else,Even,Ever,Fair,Fast,Flat,Full,Good,Half,Hard,Here,High,Home,Idly,Just,Late,Like,Live,Long,Loud,Much,Near,Nice,Okay,Once,Only,Over,Part,Past,Real,Slow,Solo,Soon,Sure,That,Then,This,Thus,Very,When,Wide"
    // Additional lists acquired from: https://bestforpuzzles.com/lists/index.html
    val fourLetterSportsWords =
        "Ball,Brag,Clob,Crib,Dibs,Dice,Faro,Golf,Grab,Indy,Jass,Judo,Keno,Klob,Ludo,Mora,Pato,Polo,Pool,Putt,Ruff,Skat,Snap,Spit,Sumo,Vint"
    val fourLetterInstrumentWords =
        "Alto,Bass,Bell,Dhol,Drum,Erhu,Fife,Gong,Harp,Horn,Koto,Lure,Lute,Lyre,Oboe,Pupe,Rote,Ruba,Vina,Viol"
    val fourLetterColors =
        "Anil,Ashy,Bice,Blue,Buff,Cyan,Drab,Ebon,Ecru,Fawn,Flax,Gilt,Gold,Gray,Grey,Hoar,Inky,Jade,Kohl,Lake,Lime,Navy,Pied,Pink,Plum,Puce,Roan,Rose,Sage,Saxe,Sand,Self,Vert,Weld,Wine,Woad"
    val fourLetterCities =
        "Elko,Erie,Gary,Hilo,Lima,Lynn,Mesa,Nome,Reno,Rome,Troy,Waco,York,Yuma"
    val fourLetterAnimals =
        "Anoa,Asse,Bear,Boar,Buck,Bull,Calf,Cavy,Colt,Cony,Coon,Dauw,Deer,Dieb,Douc,Dzho,Euro,Eyra,Fawn,Foal,Gaur,Gilt,Goat,Guib,Gyal,Hare,Hart,Hind,Hogg,Ibex,Joey,Jomo,Kine,Kudu,Lamb,Lion,Lynx,Maki,Mara,Mare,Mico,Mink,Moco,Mohr,Moke,Mole,Mona,Mule,Musk,Napu,Neat,Nowt,Oont,Orca,Oryx,Oxen,Paca,Paco,Pard,Peba,Pika,Pudu,Puma,Quey,Roan,Runt,Rusa,Saki,Seal,Skug,Sore,Tait,Tegg,Titi,Unau,Urus,Urva,Vari,Vole,Wolf,Zati,Zebu,Zobo,Zobu"

    // Returns a list of four letter words as a list
    fun getAllFourLetterWords(words : String): List<String> {
        return words.split(",")
    }

    // Returns a random four letter word from the list in all caps
    fun getRandomFourLetterWord(): String {
        val allWords = getAllFourLetterWords(fourLetterWords)
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }

    // Returns a random four letter word from the list of all sports words in all caps
    fun getRandomFourLetterSportWord(): String {
        val allWords = getAllFourLetterWords(fourLetterSportsWords)
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }

    // Returns a random four letter word from the list of instruments in all caps
    fun getRandomFourLetterInstrumentWord(): String {
        val allWords = getAllFourLetterWords(fourLetterInstrumentWords)
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }

    // Returns a random four letter color from the list of colors.
    fun getRandomFourLetterColor(): String {
        val allWords = getAllFourLetterWords(fourLetterColors)
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }

    fun getRandomFourLetterCity(): String {
        val allWords = getAllFourLetterWords(fourLetterCities)
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }

    fun getRandomFourLetterAnimal(): String {
        val allWords = getAllFourLetterWords(fourLetterAnimals)
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }
}