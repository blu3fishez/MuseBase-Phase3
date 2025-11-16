package knu.database.musebase.domain.manager.console;

public enum ManagerPageKey {
    MANAGER_MAIN,
    PROVIDER_MANAGEMENT,
    ARTIST_MANAGEMENT,
    ARTIST_DETAILS,
    SONG_MANAGEMENT,
    REQUEST_MANAGEMENT,
    SEARCH,
    EXIT;

    public String toString() {
        return this.name();
    }
}
