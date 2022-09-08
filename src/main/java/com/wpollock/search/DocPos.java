package com.wpollock.search;

/**
 * Objects of this class represent a word in a document. The document is
 * referred to by a docID, a unique int assigned to each document when added.
 * The position ("pos") is the offset of the word from the beginning; that is,
 * the first word has pos of 0, the next word has pos of 1, etc.
 *
 * @author Wayne Pollock &lt;pollock@acm.org&gt;
 */
public class DocPos implements Comparable<DocPos> {
    final long docID;
    final int pos;

    /**
     * @param docID The unique ID for this pathname. Since the files are stored in a
     *              List we could use the index of the file in the list. But then,
     *              if some file is removed from the list, the index of the
     *              following files would change.
     * @param pos   The position of the word in the document. The first word has a
     *              position of zero.
     */
    public DocPos(long docID, int pos) {
        this.docID = docID;
        this.pos = pos;
    }

    /*
     * DocPos A < DocPos B if A.docID < B.docID; the pos breaks ties:
     */
    @Override
    public int compareTo(DocPos other) {
        if (this.docID == other.docID)
            return this.pos - other.pos;
        else
            return (int) (this.docID - other.docID);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (docID ^ (docID >>> 32));
        result = prime * result + pos;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DocPos other = (DocPos) obj;
        if (docID != other.docID)
            return false;
        if (pos != other.pos)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[docID=" + docID + ", pos=" + pos + "]";
    }
}
