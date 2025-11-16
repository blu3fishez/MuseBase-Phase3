package knu.database.musebase.domain.manager.controller;

import knu.database.musebase.console.PageController;
import knu.database.musebase.domain.manager.console.ManagerPageKey;
import knu.database.musebase.domain.manager.auth.ManagerSessionWrapper;
import knu.database.musebase.exception.InvalidLoginStateException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SongManageController implements PageController<ManagerPageKey> {
    private final ManagerSessionWrapper sessionWrapper;

    @Override
    public void displayScreen() throws InvalidLoginStateException {
        if (!sessionWrapper.validateLogin()) {
            throw new InvalidLoginStateException();
        }
        System.out.println("\n--- 음원 관리 ---");
        System.out.println("관리자 ID: " + sessionWrapper.getManagerSession().getLoggedInNickname());
        System.out.println("1. 음원 정보 확인");
        System.out.println("2. 음원 추가");
        System.out.println("3. 음원 수정");
        System.out.println("4. 음원 삭제");
        System.out.println("0. 돌아가기");
        System.out.println("\n*** 인자 정보는 아티스트와 동일 ***");
    }

    @Override
    public ManagerPageKey invoke(String[] commands) {

        return ManagerPageKey.SONG_MANAGEMENT;
    }
}
