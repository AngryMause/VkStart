package ua.kek.dobriy_kot.startvk.common.utils;

import android.content.Context;

import com.vk.sdk.api.model.VKAttachments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ua.kek.dobriy_kot.startvk.model.attachment.ApiAttachment;


public class Utils {

    public static String convertAttachmentsToFontIcons(List<ApiAttachment> attachments) {
        String attachmentsString = "";

        for (ApiAttachment attachment : attachments) {
            if (attachment.getType().equals(VKAttachments.TYPE_PHOTO)) {
                attachmentsString += new String(new char[]{0xE251}) + " ";
            }
            if (attachment.getType().equals(VKAttachments.TYPE_AUDIO)) {
                attachmentsString += new String(new char[]{0xE310}) + " ";
            }
            if (attachment.getType().equals(VKAttachments.TYPE_VIDEO)) {
                attachmentsString += new String(new char[]{0xE02C}) + " ";
            }
            if (attachment.getType().equals(VKAttachments.TYPE_LINK)) {
                attachmentsString += new String(new char[]{0xE250}) + " ";
            }
            if (attachment.getType().equals(VKAttachments.TYPE_DOC)) {
                attachmentsString += new String(new char[]{0xE24D}) + " ";
            }


        }
        return attachmentsString;
    }

    public static String parseDate(long initialDate, Context context) {
        Locale currentlocale = context.getResources().getConfiguration().locale;

        Date date = new Date(initialDate * 1000);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy в H:mm", currentlocale);

        if (calendar.get(Calendar.DAY_OF_YEAR) == Calendar.getInstance().get(Calendar.DAY_OF_YEAR) &&
                calendar.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
            sdf = new SimpleDateFormat("сегодня в H:mm", currentlocale);
        } else if (calendar.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
            sdf = new SimpleDateFormat("d MMM в H:mm", currentlocale);
        }
        return sdf.format(date);
    }
}
