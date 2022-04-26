package ent.etrs.pdi.hllf.ihm.ihmImpl;

public class FabriqueConsole
{
    public static AffichageConsole fabriquerAffichageConsole()
    {
        return new AffichageConsole();
    }

    public static LectureConsole fabriquerLectureConsole()
    {
        return new LectureConsole();
    }
}
