package knu.database.musebase.domain.manager.controller;

import knu.database.musebase.console.PageController;
import knu.database.musebase.domain.manager.auth.ManagerSessionWrapper;
import knu.database.musebase.domain.manager.console.ManagerPageKey;
import knu.database.musebase.exception.InvalidLoginStateException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProviderManageController implements PageController<ManagerPageKey> {
    private final ManagerSessionWrapper sessionWrapper;

    @Override
    public void displayScreen() throws InvalidLoginStateException {
        if (!sessionWrapper.validateLogin()) {
            throw new InvalidLoginStateException();
        }
        System.out.println("\n--- 제공원 관리 ---");
        System.out.println("관리자 ID: " + sessionWrapper.getManagerSession().getLoggedInNickname());
        System.out.println("1. 제공원 목록 확인");
        System.out.println("2. 제공원 추가 [제공원 정보 인자]");
        System.out.println("3. 제공원 수정 [제공원 번호] [변화할 인자] [값]");
        System.out.println("4. 제공원 삭제 [제공원 번호]");
        System.out.println("0. 돌아가기");
    }

    @Override
    public ManagerPageKey invoke(String[] commands) {

        return ManagerPageKey.PROVIDER_MANAGEMENT;
    }
}
