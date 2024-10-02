package br.vg.mobs.enums;

import br.vg.mobs.utils.Utils;

public enum Heads {
	
	SPIDER(Utils.colorize("&aSpider"), "spider", "cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1");
	
	final String displayName;
	final String name;
	final String texture;
	
	final String url = "http://textures.minecraft.net/texture/";
	
	Heads(String displayName, String name, String texture) {
		this.displayName = displayName;
        this.name = name;
        this.texture = texture;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public String getName() {
		return this.name;
	}

	public String getTexture() {
		return this.url + this.texture;
	}
}
