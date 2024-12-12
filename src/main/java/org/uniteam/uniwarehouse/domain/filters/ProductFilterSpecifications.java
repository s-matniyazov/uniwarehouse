package org.uniteam.uniwarehouse.domain.filters;

import org.springframework.data.jpa.domain.Specification;
import org.uniteam.uniwarehouse.domain.entity.Product;
import org.uniteam.uniwarehouse.domain.entity.ProductStatus;
import org.uniteam.uniwarehouse.domain.entity.ProductType;

/**
 * @author :  Sardor Matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 12 дек. 2024
 **/
public class ProductFilterSpecifications {
    public static Specification<Product> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("nameUz"), "%" + name + "%");
    }

    public static Specification<Product> hasStatus(ProductStatus status) {
        return (root, query, criteriaBuilder) ->
                status == null ? null : criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<Product> hasType(ProductType type) {
        return (root, query, criteriaBuilder) ->
                type == null ? null : criteriaBuilder.equal(root.get("type"), type);
    }
}
