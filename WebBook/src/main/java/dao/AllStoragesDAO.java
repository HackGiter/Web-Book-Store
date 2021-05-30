package dao;

import generalClass.AllStorages;

import java.util.List;

public interface AllStoragesDAO {
    String insertAllStorages(AllStorages allStorages)throws Exception;

    boolean updateAllStorages(String arid)throws Exception;

    List<AllStorages> selectAllStoragesBySuccess(char success) throws Exception;

    AllStorages selectAllStoragesByARID(String arid) throws Exception;

    AllStorages selectAllStoragesByABID(String abid) throws Exception;

    List<AllStorages> getAllStoragesList() throws Exception;

    List<AllStorages> searchAllStorages(AllStorages allStorages);
}
