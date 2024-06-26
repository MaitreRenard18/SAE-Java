package fr.aftek;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestEpreuve extends TestCase{
    public TestEpreuve( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( TestEpreuve.class );
    }

    public void testEpreuve1(){
        /*
         * Epreuve d'athletisme feminin avec les participantes:
         * Marie-José Pérec: Athlète francaise: force: 18, agilite: 17, endurance: 10
         * Kathrine Switzer: Athlète américaine: force: 17, agilite: 19, endurance: 13
         * Nezha Bidouane: Athlète marocaine: force: 15, agilite: 15, endurance; 12
         */
        Athlete marie = new Athlete("Pérec", "Marie-José", 'F', 18, 17, 10, new Pays("France"), null); // TODO ajouter sport
        Athlete kathrine = new Athlete("Switzer", "Kathrine", 'F', 17, 19, 13, new Pays("Etats-Unis"), null); // TODO ajouter sport
        Athlete nezha = new Athlete("Bidouane", "Nezha", 'F', 15, 15, 12, new Pays("Maroc"), null); // TODO ajouter sport
        Sport athletisme = new Sport(NomSport.ATHLETISME, 15, 15, 15);
        Epreuve epreuve = new Epreuve("Athlétisme féminin", 'F', athletisme);
        epreuve.ajouteAthlete(marie);
        epreuve.ajouteAthlete(kathrine);
        epreuve.ajouteAthlete(nezha);
        assertEquals(epreuve.getParticipants().size(), 3);
        assertEquals(epreuve.getParticipants().get(0), marie);
        assertEquals(epreuve.getParticipants().get(1), kathrine);
        assertEquals(epreuve.getParticipants().get(2), nezha);
        assertEquals(epreuve.getClassement().size(), 0);
        epreuve.simuleEpreuve();
        assertEquals(epreuve.getClassement().size(), 3);
    }
}
