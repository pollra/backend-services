package wiki.neoul.i18n;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Slf4j
@Component
public class I18nManager {

    private MessageSource messageSource;

    public I18nManager(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * @param key       message.properties key
     * @return          i18n string
     */
    public String get(String key) {
        return get(key, null);
    }

    /**
     * @param key       message.properties key
     * @param args      args
     * @return          i18n string
     */
    private String get(String key, @Nullable Object[] args) {
        try {
            return messageSource.getMessage(key, args, getCurrentLocale());
        } catch (NoSuchMessageException e) {
            log.error(e.getMessage(), e);
            return "Unable to find i18n message :(";
        }
    }

    private Locale getCurrentLocale() {
        RequestAttributes attr = RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = null;

        if (attr != null) {
            req = ((ServletRequestAttributes)attr).getRequest();
        }

        if (req != null) {
            return req.getLocale();
        }

        return Locale.getDefault();
    }
}
