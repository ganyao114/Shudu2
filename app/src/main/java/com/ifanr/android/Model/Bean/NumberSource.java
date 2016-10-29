package com.ifanr.android.Model.Bean;


@SuppressWarnings("serial")
public class NumberSource {

	private String name;// 来源媒体名称、网站名等
	private String title;// 来源标题
	private String link;// 来源链接

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "NumberSource{" +
				"name='" + name + '\'' +
				", title='" + title + '\'' +
				", link='" + link + '\'' +
				'}';
	}
}
