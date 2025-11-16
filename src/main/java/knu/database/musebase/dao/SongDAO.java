package knu.database.musebase.dao;

/**
 * CREATE TABLE SONGS (
 *                        Song_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 *                        Title VARCHAR2(120) NOT NULL,
 *                        Length NUMBER NOT NULL,
 *                        Play_link VARCHAR2(255) NOT NULL,
 *                        Create_at TIMESTAMP,
 *                        Provider_id NUMBER NOT NULL REFERENCES PROVIDERS(Provider_id)
 * );
 */
public class SongDAO {
}
