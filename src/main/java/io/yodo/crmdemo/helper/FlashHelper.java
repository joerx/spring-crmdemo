package io.yodo.crmdemo.helper;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public final class FlashHelper {

    private FlashHelper() {}

    public static void setFlashInfo(RedirectAttributes ra, String message) {
        ra.addFlashAttribute("flashInfo", message);
    }

    public static void setFlashErr(RedirectAttributes ra, String message) {
        ra.addFlashAttribute("flashErr", message);
    }
}
