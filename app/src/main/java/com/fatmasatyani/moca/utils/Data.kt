package com.fatmasatyani.moca.utils

import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.DetailEntity
import com.fatmasatyani.moca.data.MovieEntity
import com.fatmasatyani.moca.data.TvShowEntity

object Data {
    fun generateMovie(): List<MovieEntity> {
        val movie: ArrayList<MovieEntity> = ArrayList()
        movie.add(
            MovieEntity(
                "M1",
                "Raya and the Last Dragon",
                "Raya and the Last Dragon is a movie starring Kelly Marie Tran, Awkwafina, and Gemma Chan. In a realm known as Kumandra, a re-imagined Earth inhabited by an ancient civilization, a warrior named Raya is determined to find the last.",
                R.drawable.mv1_raya_and_the_last_dragon,
                "https://www.youtube.com/watch?v=1VIZ89FEjYI",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Don Hall, Carlos López Estrada"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Osnat Shurer, Peter Del Vecho"
                    ),
                    DetailEntity(
                        "Music by",
                        "James Newton Howard"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Rob Dressel, Adolp Lusinsky"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Fabienne Rawley, Shannon Stein"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M2",
                "Flora & Ulysses",
                "Flora & Ulysses is a movie starring Matilda Lawler, Alyson Hannigan, and Benjamin Evan Ainsworth. The adventures of a young girl and a squirrel with superpowers.",
                R.drawable.mv2_flora_and_ulysses,
                "https://www.youtube.com/watch?v=05F8MmsiLQs",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Lena Khan"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Gil Netter"
                    ),
                    DetailEntity(
                        "Music by",
                        "Jake Monaco"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Andrew Dunn"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Jamie Gross"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M3",
                "Soul",
                "Soul is a movie starring Jamie Foxx, Tina Fey, and Graham Norton. A musician who has lost his passion for music is transported out of his body and must find his way back with the help of an infant soul learning about herself.",
                R.drawable.mv3_soul,
                "https://www.youtube.com/watch?v=xOsLIiBStEs",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Pete Docter"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Dana Murray"
                    ),
                    DetailEntity(
                        "Music by",
                        "Trent Reznor,Atticus Ross, Jon Batiste"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Matt Aspbury, Ian Megibben"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Kevin Nolting"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M4",
                "Safety",
                "Safety is a movie starring Jay Reeves, Javien Jackson, and Thaddeus J. Mixson. The story of Ray-Ray McElrathbey, a freshman football player for Clemson University, who secretly raised his younger brother on campus after his home.",
                R.drawable.mv4_safety,
                "https://www.youtube.com/watch?v=m0j8O2swT5o",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Reginald Hudlin"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Mark Ciardi, Gordon Gray"
                    ),
                    DetailEntity(
                        "Music by",
                        "Marcus Miller"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Shane Hurlbut"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Terel Gibson"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M5",
                "Godmothered",
                "Godmothered is a movie starring June Squibb, Jillian Bell, and Sonia Manzano. A young and unskilled fairy godmother ventures out on her own to prove her worth by tracking down a young girl whose request for help was ignored.",
                R.drawable.mv5_godmothered,
                "https://www.youtube.com/watch?v=KYWzEqX-J-4",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Sharon Maguire"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Justin Springer"
                    ),
                    DetailEntity(
                        "Music by",
                        "Rachel Portman"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Christopher Norr"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Gary Dollner"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M6",
                "Mulan",
                "Mulan is a movie starring Yifei Liu, Donnie Yen, and Li Gong. A young Chinese maiden disguises herself as a male warrior in order to save her father.",
                R.drawable.mv6_mulan,
                "https://www.youtube.com/watch?v=KK8FHdFluOQ",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Niki Caro"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Chris Bender, Jake Weiner, Jason T. Reed"
                    ),
                    DetailEntity(
                        "Music by",
                        "Harry Gregson-Williams"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Mandy Walker"
                    ),
                    DetailEntity(
                        "Edited by",
                        "David Coulson"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M7",
                "The One and Only Ivan",
                "The One and Only Ivan is a movie starring Sam Rockwell, Bryan Cranston, and Phillipa Soo. A gorilla named Ivan tries to piece together his past with the help of an elephant named Ruby as they hatch a plan to escape from captivity.",
                R.drawable.mv7_the_one_and_only_ivan,
                "https://www.youtube.com/watch?v=I-uIQDRS4a8",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Thea Sharrock"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Angelina Jolie, Allison Shearmur, Brigham Taylor"
                    ),
                    DetailEntity(
                        "Music by",
                        "Craig Armstrong"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Florian Ballhaus"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Barney Pilling"

                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M8",
                "Magic Camp",
                "Magic Camp is a movie starring Adam Devine, Jeffrey Tambor, and Gillian Jacobs. Andy, at the urging of his former mentor and Magic Camp owner Roy Preston, returns as a counselor to the camp of his youth hoping to reignite his career.",
                R.drawable.mv8_magic_camp,
                "https://www.youtube.com/watch?v=GAmcupYhwKA",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Mark Waters"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Suzanne Todd"
                    ),
                    DetailEntity(
                        "Music by",
                        "Rolfe Kent"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Theo van de Sande"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Bruce Green, Robert Malina"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M9",
                "Black Is King",
                "Black Is King is a movie starring Folajomi 'FJ' Akinmurele, Aweng Ade-Chuol, and Isaak Adoyi. Visual album from Beyoncé inspired by 'The Lion King'.",
                R.drawable.mv9_black_is_king,
                "https://www.youtube.com/watch?v=69MO7yU0d70",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Beyoncé Giselle Knowles-Carter,Kwasi Fordjour, Emmanuel Adjei, Blitz Bazawule, Ibra Ake, Jenn Nkiru, Jake Nava, Pierre Debusschere, Dikayl Rimmasch, Dafe Oboro"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Jeremy Sullivan, Jimi Adesanya, Blitz Bazawule, Ben Cooper, Astrid Edwards, Durwin Julies, Yoli Mes, Dafe Oboro, Akin Omotoso, Will Whitney, Lauren Baker, Jason Baum, Alex Chamberlain, Robert Day, Christophe Faubert, Brien Justiniano, Rethabile Molatela, Mothobi, Sylvia Zakhary, Nathan Scherrer, Erinn Williams"
                    ),
                    DetailEntity(
                        "Music by",
                        "James William Blades, MeLo-X, Derek Dixie"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Ryan Marie Helfant, Santiago Gonzalez, Muhammad Atta Ahmed, David Boanuh, Michael Fernandez, Erik Henriksson, Danny Hiele, Laura Merians, Nicolai Niermann, Kenechukwu Obiajulu, Malik Sayeed, Benoit Soler"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Andrew Morrow, Maria-Celeste Garrahan, Haines Hall, Tom Watson"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M10",
                "Hamilton",
                "Hamilton is a movie starring Lin-Manuel Miranda, Phillipa Soo, and Leslie Odom Jr.. The real life of one of America's foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from.",
                R.drawable.mv10_hamilton,
                "https://www.youtube.com/watch?v=DSCKfXpAGHc",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Thomas Kail"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Thomas Kail, Lin-Manuel Miranda, Jeffrey Seller"
                    ),
                    DetailEntity(
                        "Music by",
                        "Lin-Manual Miranda"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Declan Quinn"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Jonah Moran"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M11",
                "Artemis Fowl",
                "Artemis Fowl is a movie starring Ferdia Shaw, Lara McDonnell, and Josh Gad. Artemis Fowl, a young criminal prodigy, hunts down a secret society of fairies to find his missing father.",
                R.drawable.mv11_artemis_fowl,
                "https://www.youtube.com/watch?v=fl2r3Fwxz_o",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Kenneth Branagh"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Kenneth Branagh, Judy Hofflund"
                    ),
                    DetailEntity(
                        "Music by",
                        "Patrick Doyle"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Haris Zambarloukos"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Mathew Tucker"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M12",
                "Elephant",
                "Elephant is a movie starring Meghan Markle. Documentary follows an African elephant named Shani and her son Jomo as their herd make an epic journey across the Kalahari Desert.",
                R.drawable.mv12_elephant,
                "https://www.youtube.com/watch?v=bRjte6XudL8",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Mark Linfield, Vanessa Berlowitz"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Mark Linfield, Vanessa Berlowitz, Roy Conli"
                    ),
                    DetailEntity(
                        "Music by",
                        "Ramin Djawadi"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Martyn Colbeck, Mike Holding, Tom Walker"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Nigel Buck"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M13",
                "Dolphin Reef",
                "Dolphin Reef is a movie starring Natalie Portman. Echo, a young Pacific dolphin, seems far more interested in exploring his spectacular coral reef home than learning to survive in it. But lessons from his family may encourage Echo.",
                R.drawable.mv13_dolphin_reef,
                "https://www.youtube.com/watch?v=5Jwg6l0V8IE",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Alastair Fothergill"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Alastair Fothergill, Keith Scholey, Roy Conli"
                    ),
                    DetailEntity(
                        "Music by",
                        "Steven Price"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Paul Atkins"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Martin Elsbury"
                    )
                )
            )
        )

        movie.add(
            MovieEntity(
                "M14",
                "Stargirl",
                "Stargirl is a movie starring Grace VanderWaal, Darby Stanchfield, and Giancarlo Esposito. A boy becomes intrigued by a mysterious and quirky student named Stargirl and spends his time trying to know more about her.",
                R.drawable.mv14_star_girl,
                "https://www.youtube.com/watch?v=fE-e7v4bvxw",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Julia Hart"
                    ),
                    DetailEntity(
                        "Produced by",
                        "Kristin Hahn, Ellen Goldsmith-Vein, Lee Stollman, Jordan Horowitz"
                    ),
                    DetailEntity(
                        "Music by",
                        "Rob Simonsen"
                    ),
                    DetailEntity(
                        "Cinematography",
                        "Bryce Fortner"
                    ),
                    DetailEntity(
                        "Edited by",
                        "Shayar Bansali, Tracey Wadmore-Smith"
                    )
                )
            )
        )
        return movie
    }

    fun generateTvShow(): List<TvShowEntity> {
        val tvShow: ArrayList<TvShowEntity> = ArrayList()
        tvShow.add(
            TvShowEntity(
                "T1",
                "Tom & Jerry",
                "Tom and Jerry is an American animated media franchise and series of comedy short films created in 1940 by William Hanna and Joseph Barbera. Best known for its 161 theatrical short films by Metro-Goldwyn-Mayer, the series centers on the rivalry between the titular characters of a cat named Tom and a mouse named Jerry.",
                R.drawable.tv1_tom_and_jerry,
                "https://www.youtube.com/watch?v=ZcopvkSgBgc",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "William Hanna(1940-58), Joseph Barbera (1940-58), Gene Deitch (1961-62), Chuck Jones (1963 - 67), Maurice Noble (1964-67), Abe Levitow (1965-67), Tom Ray (1966-67), Ben Washam (1966-67)"
                    ),
                    DetailEntity(
                        "Produced by",
                        " Rudolf Ising (1940), Fred Quimby (1940–55), William Hanna (1955–58), Joseph Barbera (1955–58), William L. Snyder (1961–62), Chuck Jones (1963–67), Walter Bien (1963–65), Les Goldman (1963–67), Earl Jonas (1965–67)"
                    ),
                    DetailEntity(
                        "Running time",
                        "6-10 minutes"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T2",
                "Scooby-Doo",
                "Scooby-Doo is an American animated franchise comprising many animated television series produced from 1969 to the present, as well as their derivative media. Writers Joe Ruby and Ken Spears created the original series, Scooby-Doo, Where Are You!, for Hanna-Barbera Productions in 1969.",
                R.drawable.tv2_scooby_doo,
                "https://www.youtube.com/watch?v=dXFbi1NCcMU",
                listOf(
                    DetailEntity(
                        "Created by",
                        "Joe Ruby, Ken Spears"
                    ),
                    DetailEntity(
                        "Original work",
                        "Scooby-Doo, Where Are You!"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T3",
                "SpongeBob SquarePants",
                "SpongeBob SquarePants (also simply referred to as SpongeBob) is an American animated comedy television series created by marine science educator and animator Stephen Hillenburg for Nickelodeon. The series chronicles the adventures and endeavors of the title character and his aquatic friends in the fictional underwater city of Bikini Bottom.",
                R.drawable.tv3_spongebob,
                "https://www.youtube.com/watch?v=Sdj-5SQGCMU",
                listOf(
                    DetailEntity(
                        "Created by",
                        "Stephen Hillenburg"
                    ),
                    DetailEntity(
                        "Developed by",
                        "Derek Drymon, Tim Hill, Nick Jennings"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T4",
                "The Simpsons",
                "The Simpsons is an American animated sitcom created by Matt Groening for the Fox Broadcasting Company. The series is a satirical depiction of a middle class American lifestyle epitomized by the Simpson family, which consists of Homer, Marge, Bart, Lisa, and Maggie.",
                R.drawable.tv4_the_simpsons,
                "https://www.youtube.com/watch?v=WxLfAU5yS0o",
                listOf(
                    DetailEntity(
                        "Created by",
                        "Matt Groening"
                    ),
                    DetailEntity(
                        "Developed by",
                        "James L. Brooks, Matt Groening, Sam Simon"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T5",
                "The Bugs Bunny Show",
                "The Bugs Bunny Show is an animated television anthology series hosted by Bugs Bunny, that was mainly composed of Looney Tunes and Merrie Melodies cartoons released by Warner Bros. between August 1, 1948 and the end of 1969.",
                R.drawable.tv5_bugs_bunny,
                "https://www.youtube.com/watch?v=JLAQpaP2Hio",
                listOf(
                    DetailEntity(
                        "Directed by",
                        "Chuck Jones, Friz Freleng, Robert McKimson"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T6",
                "DuckTales",
                "DuckTales is an American animated television series produced by Disney Television Animation. It premiered on September 18, 1987 and ended on November 28, 1990 with a total of four seasons and 100 episodes.",
                R.drawable.tv6_ducktales,
                "https://www.youtube.com/watch?v=SRkbaUiYlNY",
                listOf(
                    DetailEntity(
                        "Developed by",
                        "Jymn Magon, Brad Landreth"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T7",
                "Teenage Mutant Ninja Turtles",
                "Teenage Mutant Ninja Turtles is an animated television series produced by Murakami-Wolf-Swenson and the French company IDDH. The pilot was shown during the week of December 14, 1987 in syndication as a five-part miniseries and the show began its official run on October 1, 1988.",
                R.drawable.tv7_teenage_mutant_ninja_turtle,
                "https://www.youtube.com/watch?v=jOuSCfJgpd8",
                listOf(
                    DetailEntity(
                        "Developed by",
                        "David Wise, Patti Howeth"
                    ),
                    DetailEntity(
                        "Directed by",
                        "Yoshikatsu, Bill Wolf, Fred Wold, Tony Love"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T8",
                "Family Guy",
                "Family Guy is an American adult animated sitcom created by Seth MacFarlane for the Fox Broadcasting Company. The series centers on the Griffins, a family consisting of parents Peter and Lois; their children Meg, Chris, and Stewie; and their anthropomorphic pet dog Brian.",
                R.drawable.tv8_family_guy,
                "https://www.youtube.com/watch?v=9D0JDpkLApw",
                listOf(
                    DetailEntity(
                        "Created by",
                        "Seth MacFarlene"
                    ),
                    DetailEntity(
                        "Developed by",
                        "Seth MacFarlene, David Zuckerman"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T9",
                "The Pink Panther Show",
                "The Pink Panther Show is a showcase of cartoon shorts produced by David H. DePatie and Friz Freleng between 1969 and 1979, starring the animated Pink Panther character from the opening credits of the live-action films.",
                R.drawable.tv9_the_pink_panther,
                "https://www.youtube.com/watch?v=z93qRyEY_wQ",
                listOf(
                    DetailEntity(
                        "Created by",
                        "David H. DePatie, Friz Freleng"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T10",
                "Phineas and Ferb",
                "Phineas and Ferb is an American animated comedy-musical television series. Originally broadcast as a one-episode preview on August 17, 2007 and again previewed on September 28, 2007, the series officially premiered on February 1, 2008 on Disney Channel, and follows Phineas Flynn and his English stepbrother Ferb Fletcher on summer vacation.",
                R.drawable.tv10_phineas_and_ferb,
                "https://www.youtube.com/watch?v=ehhmN6kPDIU",
                listOf(
                    DetailEntity(
                        "Created by",
                        "Dan Povenmire, Jeff 'Swampy' Marsh"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T11",
                "Garfield and Friends",
                "Garfield and Friends is an American animated television series based on the comic strip Garfield by Jim Davis. The show was produced by Film Roman, in association with United Feature Syndicate and Paws, Inc., and ran on CBS Saturday mornings from September 17, 1988 to December 10, 1994, with reruns airing until October 7, 1995.",
                R.drawable.tv11_garfield,
                "https://www.youtube.com/watch?v=Z3yalgthRuA",
                listOf(
                    DetailEntity(
                        "Created by",
                        "Jim Davis"
                    ),
                    DetailEntity(
                        "Directed by",
                        "Jeff Hall, Tom Ray, Dave Brain, Vincent Davis, Ron Myrick"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T12",
                "The Smurfs",
                "The Smurfs is an American-Belgian animated fantasy-comedy television series that aired on NBC from September 12, 1981, to December 2, 1989.",
                R.drawable.tv12_smurfs,
                "https://www.youtube.com/watch?v=fJxLNvhce2w",
                listOf(
                    DetailEntity(
                        "Created by",
                        "Pierre 'Peyo' Culliford"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T13",
                "Spider-Man",
                "Spider-Man, also known as Spider-Man: The Animated Series, is an American animated television series based on the Marvel Comics superhero, Spider-Man. The show ran on Fox Kids from November 19, 1994, to January 31, 1998, and ran reruns on the Jetix block on Toon Disney.",
                R.drawable.tv13_spiderman,
                "https://www.youtube.com/watch?v=F65R9s_s_Jw",
                listOf(
                    DetailEntity(
                        "Written by",
                        "John Semper"
                    )
                )
            )
        )

        tvShow.add(
            TvShowEntity(
                "T14",
                "Strawberry Shortcake",
                "Strawberry Shortcake is a cartoon character originally used in greeting cards, but who was later expanded to include dolls, posters, and other products. The Strawberry Shortcake properties also include a toy line of the character's friends and pets.",
                R.drawable.tv14_strawberry_shortcake,
                "https://www.youtube.com/watch?v=X87XjEXQatI",
                listOf(
                    DetailEntity(
                        "Created by",
                        "Barbi Sargent, Muriel Fahrion, Fran Kariotakis"
                    )
                )
            )
        )
        return tvShow
    }

    fun movieDetails(id: String): MovieEntity? {
        val movies = generateMovie()
        return movies.find { it.movieId  == id }
    }

    fun tvShowDetails(id: String): TvShowEntity? {
        val tvShows = generateTvShow()
        return tvShows.find { it.tvShowId == id }
    }
}