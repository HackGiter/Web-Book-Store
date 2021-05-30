package dao;

import generalClass.Expresses;
import generalClass.InExpress;

import java.util.List;

public interface ExpressesDAO {
    boolean insertExpresses(Expresses expresses) ;

    public boolean updateExpresses(Expresses expresses) ;

    public List<Expresses> selectExpressesByName(String name) ;

    List<Expresses> selectExpressesByDeliver(String deliver) ;

    public List<Expresses> selectExpressesBySuccess(char success) ;

    public Expresses selectExpressesByOID(String oid) ;

    public Expresses selectExpressesByEDID(String edid) ;

    List<Expresses> getExpressedList() ;

    String insertExpressByInExpress(InExpress inExpress, String ed, String deliver, String name, String Phone) ;

    int[] patchInsertExpress(List<Expresses> expressesList);

}
