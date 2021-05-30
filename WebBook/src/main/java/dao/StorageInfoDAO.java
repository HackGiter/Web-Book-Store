package dao;

import generalClass.StorageInfo;

import java.util.List;

public interface StorageInfoDAO {
    List<String> countStorages();
    int insertStorageInfo(StorageInfo storageInfo);
    StorageInfo getStorageInfo(String said);
    List<StorageInfo> getStorageInfoList();

}
