package rock.util.net;

/**
 * 帮助生成Get的URL
 * Created by Rock on 2015/1/12.
 */
public class GetUrlBuilder {

    private StringBuilder mUrl;
    private boolean isFirst = true;

    public GetUrlBuilder(String url) {
        mUrl = new StringBuilder(url + "?");
    }

    public GetUrlBuilder addParam(String name, String value) {
        if (isFirst) {
            mUrl.append(name).append("=").append(value);
            isFirst = false;
        } else {
            mUrl.append("&").append(name).append("=").append(value);
        }
        return this;
    }

    public String build() {
        return mUrl.toString();
    }

}