package us.codecraft.webmagic.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ProcessResult;
import us.codecraft.webmagic.Site;

/**
 * Interface to be implemented to customize a crawler.<br>
 * <br>
 * In PageProcessor, you can customize:
 * <br>
 * start urls and other settings in {@link Site}<br>
 * how the urls to fetch are detected               <br>
 * how the data are extracted and stored             <br>
 *
 * @author code4crafter@gmail.com <br>
 * @see Site
 * @see Page
 * @since 0.1.0
 */
public interface PageProcessor {

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    void process(Page page);

    /**
     * process the page, extract urls to fetch, extract the data and store ,并且返回统计信息
     *
     * @param page page
     * @return ProcessResult 处理结果
     */
    default  ProcessResult processAndStatistic(Page page) {
        long start = System.currentTimeMillis();
        process(page);
        long end = System.currentTimeMillis();
        return new ProcessResult((int) (end - start));
    }

    /**
     * get the site settings
     *
     * @return site
     * @see Site
     */
    default Site getSite() {
        return Site.me();
    }

}
