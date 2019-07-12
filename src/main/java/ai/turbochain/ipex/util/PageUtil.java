package ai.turbochain.ipex.util;

import org.springframework.data.domain.Page;

import ai.turbochain.ipex.pagenation.EntityPage;

public class PageUtil {

    public static EntityPage page(Page page , int pageNo , int pageSize){
        EntityPage entityPage = new EntityPage();
        entityPage.setCount(page.getTotalElements());
        entityPage.setTotalPage(page.getTotalPages());
        entityPage.setList(page.getContent());
        entityPage.setCurrentPage(pageNo);
        entityPage.setPageSize(pageSize);
        return entityPage ;
    }
}
