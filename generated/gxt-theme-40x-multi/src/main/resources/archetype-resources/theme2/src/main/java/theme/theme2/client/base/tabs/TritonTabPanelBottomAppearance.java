#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.theme.theme2.client.base.tabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

public class TritonTabPanelBottomAppearance extends Css3TabPanelBottomAppearance {

  public interface TritonTabPanelBottomResources extends Css3TabPanelBottomResources {

    @Override
    @Source({"Css3TabPanelBottom.gss", "TritonTabPanelBottom.gss"})
    TritonTabPanelBottomStyle style();

    @Override
    @ImageOptions(height = 16, width = 16)
    ImageResource activeTabClose();

    @Override
    @ImageOptions(height = 16, width = 16)
    ImageResource activeTabCloseOver();

    @Override
    @ImageOptions(height = 16, width = 16)
    ImageResource tabClose();

    @Override
    @ImageOptions(height = 16, width = 16)
    ImageResource tabCloseOver();
  }

  public interface TritonTabPanelBottomStyle extends Css3TabPanelBottomStyle {
  }

  public TritonTabPanelBottomAppearance() {
    super(GWT.<TritonTabPanelBottomResources> create(TritonTabPanelBottomResources.class));
  }
}
