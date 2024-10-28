package ru.clevertec.cleverbank.command.impl.admin.accounts;

import jakarta.servlet.http.HttpServletRequest;
import ru.clevertec.cleverbank.command.Command;
import ru.clevertec.cleverbank.command.impl.admin.attributes.AccountAttributes;
import ru.clevertec.cleverbank.constants.PageName;
import ru.clevertec.cleverbank.configs.container.ComponentFactory;
import ru.clevertec.cleverbank.exception.CommandException;
import ru.clevertec.cleverbank.mapper.json.AccountJsonMapper;
import ru.clevertec.cleverbank.model.Account;
import ru.clevertec.cleverbank.service.AccountService;
import ru.clevertec.cleverbank.service.impl.AccountServiceImpl;

import static ru.clevertec.cleverbank.constants.JspConstants.JSON_DATA;
import static ru.clevertec.cleverbank.constants.JspConstants.CURRENT_ENTITY;

public class UpdateAccountCommand implements Command {

    private AccountService accountService = ComponentFactory.getComponent(AccountServiceImpl.class);
    private AccountJsonMapper jsonMapper = ComponentFactory.getComponent(AccountJsonMapper.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        Account account = jsonMapper.toEntity(request.getParameter(JSON_DATA));

        if (accountService.update(account)) {
            request.setAttribute(CURRENT_ENTITY, jsonMapper.toJson(account));
            AccountAttributes.setPageAttributes(request);
            return PageName.CRUD_PAGE;
        }

        request.setAttribute(MESSAGE, "Account with id="+account.getId()+" has not been updated!");
        return PageName.ERROR_PAGE;
    }

}