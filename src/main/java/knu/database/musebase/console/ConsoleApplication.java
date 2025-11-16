package knu.database.musebase.console;

import knu.database.musebase.crypto.PasswordEncryptor;
import knu.database.musebase.crypto.PasswordEncryptorImpl;
import knu.database.musebase.dao.ArtistDAO;
import knu.database.musebase.dao.ProviderDAO;
import knu.database.musebase.dao.SongDAO;
import knu.database.musebase.domain.manager.console.ManagerPageKey;
import knu.database.musebase.domain.manager.auth.ManagerAuthService;
import knu.database.musebase.domain.manager.auth.ManagerSessionWrapper;
import knu.database.musebase.domain.manager.controller.ArtistManageController;
import knu.database.musebase.domain.manager.controller.ManagerMainController;
import knu.database.musebase.domain.manager.controller.ProviderManageController;
import knu.database.musebase.domain.manager.controller.SongManageController;
import knu.database.musebase.domain.manager.controller.SongRequestManageController;
import knu.database.musebase.domain.manager.dao.ManagerDAO;
import knu.database.musebase.domain.manager.dao.SongRequestDAO;
import knu.database.musebase.exception.InvalidLoginStateException;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleApplication {
    public void run(ConsoleMode mode) throws IllegalArgumentException {
        if (mode == ConsoleMode.MANAGER) {
            runManager();
        }
        else {
            run();
        }
    }

    private void runManager() {

        // doing di

        // applicaiton states
        ManagerPageKey managerPageKey = ManagerPageKey.MANAGER_MAIN;
        ManagerSessionWrapper managerSessionWrapper = new ManagerSessionWrapper();

        // dao
        var managerDAO = new ManagerDAO();
        var songDAO = new SongDAO();
        var providerDAO = new ProviderDAO();
        var songRequestDAO = new SongRequestDAO();
        var artistDAO = new ArtistDAO();

        // crypto
        var passwordEncryptor = (PasswordEncryptor) new PasswordEncryptorImpl();

        // services
        var managerAuthService = new ManagerAuthService(passwordEncryptor, managerDAO);

        var pageControllers = new HashMap<ManagerPageKey, PageController<ManagerPageKey>>();

        pageControllers.put(ManagerPageKey.ARTIST_MANAGEMENT, new ArtistManageController(managerAuthService, managerSessionWrapper));
        pageControllers.put(ManagerPageKey.MANAGER_MAIN, new ManagerMainController(managerSessionWrapper, managerAuthService));
        pageControllers.put(ManagerPageKey.PROVIDER_MANAGEMENT, new ProviderManageController(managerSessionWrapper));
        pageControllers.put(ManagerPageKey.SONG_MANAGEMENT, new SongManageController(managerSessionWrapper));
        pageControllers.put(ManagerPageKey.REQUEST_MANAGEMENT, new SongRequestManageController(managerSessionWrapper));
        pageControllers.put(ManagerPageKey.ARTIST_DETAILS, null);
        pageControllers.put(ManagerPageKey.EXIT, null);

        Scanner scanner = new Scanner(System.in);


        while (managerPageKey != ManagerPageKey.EXIT) {
            PageController<ManagerPageKey> pageController = pageControllers.get(managerPageKey);

            System.out.println(managerPageKey);
            try {
                pageController.displayScreen();

            } catch (InvalidLoginStateException e) {
                System.out.println(e.getMessage());
                managerPageKey = ManagerPageKey.MANAGER_MAIN;
                continue;
            }

            String command = scanner.nextLine();
            managerPageKey = pageController.invoke(command.split(" "));
        }

        scanner.close();
    }

    private void run() {

    }
}
