package dao;

import generalClass.Storages;

import java.util.List;

public interface StorageDAO {
    boolean insertStorages(Storages storages)throws Exception;

    boolean updateStorages(String arid)throws Exception;

    List<Storages> selectStoragesByPID(String pid) throws Exception;

    List<Storages> selectStoragesByARID(String arid) throws Exception;

    List<Storages> getStoragesList() throws Exception;

    Storages getStorages(String bid) throws Exception;

    int[] patchInsertStorages(List<Storages> storagesList) throws Exception;
}
