package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(50, "points").build();

        m = query.oneOf(m1, m2).build();

        System.out.println("");
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        m = query.oneOf(
                query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build(),
                query.playsIn("EDM")
                .hasAtLeast(50, "points").build()
        ).build();

        System.out.println("");
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
