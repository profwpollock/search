package com.wpollock.search;

/**
 * Each object of this class represents an indexed file. Each one has an ID, a
 * pathname, and a last modified timestamp. Since the items are in a collection,
 * I decided to implement Comparable. Objects are immutable.
 *
 * @author wpollock
 */
public class FileItem implements Comparable<FileItem> {
    public final long fileID;
    public final String fileName;
    public long modificationTime;

    public FileItem(long fileID, String fileName, long modificationTime) {
        this.fileID = fileID;
        this.fileName = fileName;
        this.modificationTime = modificationTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (fileID ^ (fileID >>> 32));
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FileItem other = (FileItem) obj;
        if (fileID != other.fileID) {
            return false;
        }
        if (fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!fileName.equals(other.fileName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FileItem [fileName=" + fileName + "]";
    }

    @Override
    public int compareTo(FileItem other) {
        return (int) (fileID - other.fileID);
    }
}
